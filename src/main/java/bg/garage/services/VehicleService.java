package bg.garage.services;

import java.util.List;

import bg.garage.model.CarModel;

public interface VehicleService {

    CarModel getCar(Long carId);

    void addCar(CarModel carModel);

    void deleteCar(Long carId);

    List<CarModel> getUserCars(Long userId);

    List<CarModel> getAllCars();

    void deleteAllCarByUser(long userId);
}
