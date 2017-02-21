package bg.garage.repository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.garage.entity.CarEntity;
import bg.garage.model.CarModel;
import bg.garage.model.RepairModel;

@Component
public class CarRepositoryImpl implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    CarRepository carRepository;

    @Autowired
    private RepairRepositoryImpl repairRepository;

    public void addCar(CarModel carModel) {
        CarEntity carEntity = modelToEntity(carModel);
        carRepository.save(carEntity);
    }

    public Set<CarModel> getUserCars(Long userId) {
        Set<CarModel> cars = new HashSet<>();
        Set<CarEntity> carsEntity = carRepository.findByOwnerId(userId);

        for (CarEntity carEntity : carsEntity) {
            CarModel model = entityToModel(carEntity);
            cars.add(model);
        }
        return cars;
    }

    public Set<CarModel> getAllCars() {
        Set<CarModel> allCars = new HashSet<>();
        Iterable<CarEntity> cars = carRepository.findAll();

        for (CarEntity entity : cars) {
            allCars.add(entityToModel(entity));
        }

        return allCars;
    }

    public void deleteCar(Long id) {
        carRepository.delete(id);
    }

    public void deleteCarByUser(long delitedUserId) {
        for (CarModel model : getUserCars(delitedUserId)) {
            repairRepository.deleteRepairsByCar(model.getId());
            deleteCar(model.getId());
        }
    }

    private CarModel entityToModel(CarEntity entity) {

        Set<RepairModel> repairs = repairRepository.findAllByCarId(entity.getId());

        CarModel model = new CarModel(entity.getId(), entity.getOwnerId(), entity.getRegistrationPlate(),
                entity.getMarka(), entity.getModel(), entity.getVin(), entity.getEngineType(),
                entity.getCurrentMilage(), entity.getYearManifacture(), entity.getRoadTaxisEndDate(),
                entity.getAnualCheckEndDate(), entity.getLiabilityInsuranseEndDate(), entity.getFullInsuranseEndDate(),
                entity.getVinnetesEndDate(), entity.getLastVisitDate(), repairs);

        return model;
    }

    private CarEntity modelToEntity(CarModel model) {
        CarEntity entity = new CarEntity(model.getOwnerId(), model.getRegistrationPlate(), model.getMarka(),
                model.getModel(), model.getVin(), model.getEngineType(), model.getCurrentMilage(),
                model.getYearManifacture(), model.getRoadTaxisEndDate(), model.getAnualCheckEndDate(),
                model.getLiabilityInsuranseEndDate(), model.getFullInsuranseEndDate(), model.getVinnetesEndDate(),
                model.getLastVisitDate());
        if (model.getId() != null) {
            entity.setId(model.getId());
        }

        return entity;
    }
}
