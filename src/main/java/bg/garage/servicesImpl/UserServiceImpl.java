package bg.garage.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.garage.model.UserModel;
import bg.garage.repository.UserRepositoryImpl;
import bg.garage.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Override
    public void addUser(UserModel user) {
        userRepositoryImpl.addUser(user);
    }

    @Override
    public void removeUser(UserModel userModel) {
        userRepositoryImpl.deleteUser(userModel.getId());
    }

    @Override
    public UserModel getUserModel(String username) {
        return userRepositoryImpl.getUser(username);
    }

    public List<UserModel> getAllUsers() {
        return userRepositoryImpl.getAllUsers();
    }
}
