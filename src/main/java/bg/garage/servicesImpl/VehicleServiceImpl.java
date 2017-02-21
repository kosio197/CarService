package bg.garage.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.garage.model.CarModel;
import bg.garage.repository.CarRepositoryImpl;
import bg.garage.services.VehicleService;

@Component("vehicleServiceImpl")
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private CarRepositoryImpl carRepositoryImpl;

    @Override
    public void addCar(CarModel carModel) {
        carRepositoryImpl.addCar(carModel);
    }

    @Override
    public void removeCar(CarModel carModel) {
        carRepositoryImpl.deleteCar(carModel.getId());

    }

    @Override
    public List<CarModel> getAllCarsFromUser(Long userId) {
        List<CarModel> cars = new ArrayList<>();
        cars.addAll(carRepositoryImpl.getUserCars(userId));
        return cars;
    }

    @Override
    public List<CarModel> getAllCars() {
        List<CarModel> cars = new ArrayList<>();
        cars.addAll(carRepositoryImpl.getAllCars());
        return cars;
    }
}
