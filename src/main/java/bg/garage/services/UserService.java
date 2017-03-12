package bg.garage.services;

import java.util.List;

import bg.garage.model.UserModel;

public interface UserService {

    void addUser(UserModel userModel);

    String getUserNameById(Long ownerId);

    UserModel getUserByUsername(String username);

    UserModel getUserByEmail(String email);

    List<UserModel> getAllUsers();

    void deleteUser(Long userId);

    void invalidateUserSession();

}
