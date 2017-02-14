package bg.garage.services;

import bg.garage.model.CarModel;
import bg.garage.model.UserModel;

public interface UserService {

    void addUser(UserModel user);

    void removeUser(UserModel userModel);

    void addCar(UserModel userModel, CarModel carModel);

    void removeCar(UserModel userModel, CarModel carModel);

    UserModel getUserModel(String username);
}
