package bg.garage.services;

import bg.garage.model.UserModel;

public interface UserService {

    void addUser(UserModel user);

    void removeUser(UserModel userModel);

    UserModel getUserModel(String username);
}
