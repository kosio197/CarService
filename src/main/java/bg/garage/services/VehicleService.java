package bg.garage.services;

import java.util.List;

import bg.garage.model.CarModel;

public interface VehicleService {

    void addCar(CarModel carModel);

    void removeCar(CarModel carModel);

    List<CarModel> getAllCarsFromUser(Long userId);

    List<CarModel> getAllCars();
}
