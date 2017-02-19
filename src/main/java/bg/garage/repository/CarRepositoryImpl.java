package bg.garage.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.garage.entity.CarBeltEntity;
import bg.garage.entity.CarEntity;
import bg.garage.entity.CarFluidEntity;
import bg.garage.entity.CarRepairEntity;
import bg.garage.entity.PartEntity;
import bg.garage.entity.PictureEntity;
import bg.garage.model.CarBeltModel;
import bg.garage.model.CarFluidModel;
import bg.garage.model.CarModel;
import bg.garage.model.CarRepairModel;
import bg.garage.model.PartModel;
import bg.garage.model.PictureModel;

@Component
public class CarRepositoryImpl {

    @Autowired
    CarRepository carRepository;

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

    private CarModel entityToModel(CarEntity entity) {

        CarFluidModel engineOil = new CarFluidModel(entity.getEngineOil().getId(),
                entity.getEngineOil().getChangeDate(), entity.getEngineOil().getMilage(),
                entity.getEngineOil().getFluideType());

        CarFluidModel transmisionOil = new CarFluidModel(entity.getTransmisionOil().getId(),
                entity.getTransmisionOil().getChangeDate(), entity.getTransmisionOil().getMilage(),
                entity.getTransmisionOil().getFluideType());

        CarFluidModel differentialOil = new CarFluidModel(entity.getDifferentialOil().getId(),
                entity.getDifferentialOil().getChangeDate(), entity.getDifferentialOil().getMilage(),
                entity.getDifferentialOil().getFluideType());

        CarFluidModel hidraulicOil = new CarFluidModel(entity.getHidraulicOil().getId(),
                entity.getHidraulicOil().getChangeDate(), entity.getHidraulicOil().getMilage(),
                entity.getHidraulicOil().getFluideType());

        CarFluidModel breakFluid = new CarFluidModel(entity.getBreakFluid().getId(),
                entity.getBreakFluid().getChangeDate(), entity.getBreakFluid().getMilage(),
                entity.getBreakFluid().getFluideType());

        CarFluidModel antifrize = new CarFluidModel(entity.getAntifreeze().getId(),
                entity.getAntifreeze().getChangeDate(), entity.getAntifreeze().getMilage(),
                entity.getAntifreeze().getFluideType());

        CarFluidModel refrigerant = new CarFluidModel(entity.getRefrigerant().getId(),
                entity.getRefrigerant().getChangeDate(), entity.getRefrigerant().getMilage(),
                entity.getRefrigerant().getFluideType());

        CarBeltModel timingBelt = new CarBeltModel(entity.getTimingBelt().getId(),
                entity.getTimingBelt().getChangeDate(), entity.getTimingBelt().getMilage(),
                entity.getTimingBelt().getBeltType());

        Set<CarBeltModel> accsesoryBelt = new HashSet<>();
        for (CarBeltEntity belt : entity.getAccessoaryBelt()) {
            CarBeltModel accsesory = new CarBeltModel(belt.getId(), belt.getChangeDate(), belt.getMilage(),
                    belt.getBeltType());
            accsesoryBelt.add(accsesory);
        }

        Set<CarRepairModel> repairs = new HashSet<>();
        for (CarRepairEntity repair : entity.getRepairs()) {

            Set<PartModel> parts = new HashSet<>();
            for (PartEntity partEntity : repair.getParts()) {
                PartModel partModel = new PartModel(partEntity.getId(), partEntity.getArticle(), partEntity.getMark(),
                        partEntity.getCatalogNumber(), partEntity.getDescription(), partEntity.getPieces(),
                        partEntity.getPrice());
                parts.add(partModel);
            }

            Set<PictureModel> pictures = new HashSet<>();
            for (PictureEntity pictureEntity : repair.getRepairPictures()) {
                PictureModel pictureModel = new PictureModel(pictureEntity.getId(), pictureEntity.getPicture());
                pictures.add(pictureModel);
            }

            CarRepairModel model = new CarRepairModel(repair.getId(), repair.getRepairDate(), repair.getCurrentMilage(),
                    repair.getDescription(), repair.getRecomendetUpcomingRepair(), pictures, parts);
            repairs.add(model);
        }

        CarModel model = new CarModel(entity.getId(), entity.getOwnerId(), entity.getPictures(),
                entity.getRegistrationPlate(), entity.getMarka(), entity.getModel(), entity.getYearManifacture(),
                entity.getEngineType(), entity.getCurrentMilage(), entity.getRoadTaxisEndDate(),
                entity.getAnualCheckEndDate(), entity.getLiabilityInsuranseEndDate(), entity.getFullInsuranseEndDate(),
                entity.getVinnetesEndDate(), engineOil, transmisionOil, differentialOil, hidraulicOil, breakFluid,
                antifrize, refrigerant, timingBelt, accsesoryBelt, repairs);

        return model;
    }

    private CarEntity modelToEntity(CarModel model) {

        CarFluidEntity engineOil = new CarFluidEntity(model.getEngineOil().getChangeDate(),
                model.getEngineOil().getMilage(), model.getEngineOil().getFluideType());

        CarFluidEntity transmisionOil = new CarFluidEntity(model.getTransmisionOil().getChangeDate(),
                model.getTransmisionOil().getMilage(), model.getTransmisionOil().getFluideType());

        CarFluidEntity differentialOil = new CarFluidEntity(model.getDifferentialOil().getChangeDate(),
                model.getDifferentialOil().getMilage(), model.getDifferentialOil().getFluideType());

        CarFluidEntity hidraulicOil = new CarFluidEntity(model.getHidraulicOil().getChangeDate(),
                model.getHidraulicOil().getMilage(), model.getHidraulicOil().getFluideType());

        CarFluidEntity breakFluid = new CarFluidEntity(model.getBreakFluid().getChangeDate(),
                model.getBreakFluid().getMilage(), model.getBreakFluid().getFluideType());

        CarFluidEntity antifreeze = new CarFluidEntity(model.getAntifreeze().getChangeDate(),
                model.getAntifreeze().getMilage(), model.getAntifreeze().getFluideType());

        CarFluidEntity refrigerant = new CarFluidEntity(model.getRefrigerant().getChangeDate(),
                model.getRefrigerant().getMilage(), model.getRefrigerant().getFluideType());

        CarBeltEntity timingBelt = new CarBeltEntity(model.getTimingBelt().getChangeDate(),
                model.getTimingBelt().getMilage(), model.getTimingBelt().getBeltType());

        CarEntity entity = new CarEntity(model.getUserId(), model.getPictures(), model.getRegistrationPlate(),
                model.getMarka(), model.getModel(), model.getYearManifacture(), model.getEngineType(),
                model.getCurrentMilage(), model.getRoadTaxisEndDate(), model.getAnualCheckEndDate(),
                model.getLiabilityInsuranseEndDate(), model.getFullInsuranseEndDate(), model.getVinnetesEndDate(),
                engineOil, transmisionOil, differentialOil, hidraulicOil, breakFluid, antifreeze, refrigerant,
                timingBelt);

        // if objects already exist then add All them to entity
        if (model.getId() != null) {
            entity.setId(model.getId());
        }

        if (model.getAccessoaryBelt().size() > 0) {
            Set<CarBeltEntity> accsesoryBelt = new HashSet<>();

            for (CarBeltModel carBeltModel : model.getAccessoaryBelt()) {
                CarBeltEntity carBeltEntity = new CarBeltEntity(carBeltModel.getChangeDate(), carBeltModel.getMilage(),
                        carBeltModel.getBeltType());
                if (carBeltModel.getId() != null) {
                    carBeltEntity.setId(carBeltModel.getId());
                }
                accsesoryBelt.add(carBeltEntity);
            }
            entity.setAccessoaryBelt(accsesoryBelt);
        }

        if (model.getRepairs().size() > 0) {
            Set<CarRepairEntity> carRepairEntities = new HashSet<>();

            for (CarRepairModel carRepairModel : model.getRepairs()) {
                CarRepairEntity carRepairEntity = new CarRepairEntity(carRepairModel.getRepairDate(),
                        carRepairModel.getCurrentMilage(), carRepairModel.getDescription(),
                        carRepairModel.getRecomendetUpcomingRepair());

                if (carRepairModel.getId() != null) {
                    carRepairEntity.setId(carRepairModel.getId());
                }

                if (carRepairModel.getParts().size() > 0) {
                    Set<PartEntity> partEntities = new HashSet<>();
                    for (PartModel partModel : carRepairModel.getParts()) {
                        PartEntity partEntity = new PartEntity(partModel.getArticle(), partModel.getMark(),
                                partModel.getCatalogNumber(), partModel.getDescription(), partModel.getPieces(),
                                partModel.getPrice());
                        if (partModel.getId() != null) {
                            partEntity.setId(partModel.getId());
                        }
                        partEntities.add(partEntity);
                    }
                    carRepairEntity.setParts(partEntities);
                }

                if (carRepairModel.getRepairPictures().size() > 0) {
                    Set<PictureEntity> pictureEntities = new HashSet<>();
                    for (PictureModel pictureModel : carRepairModel.getRepairPictures()) {
                        PictureEntity pictureEntity = new PictureEntity(pictureModel.getPicture());
                        if (pictureModel.getId() != null) {
                            pictureEntity.setId(pictureModel.getId());
                        }
                        pictureEntities.add(pictureEntity);
                    }
                    carRepairEntity.setRepairPictures(pictureEntities);
                }

            }
            entity.setRepairs(carRepairEntities);
        }

        return entity;
    }
}
