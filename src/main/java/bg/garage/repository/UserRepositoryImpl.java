package bg.garage.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.garage.entity.UserEntity;
import bg.garage.model.CarModel;
import bg.garage.model.UserModel;

@Component
public class UserRepositoryImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepositoryImpl carRepositoryImpl;

    public void addUser(UserModel userModel) {
        UserEntity userEntity = userModelToEntity(userModel);
        userRepository.save(userEntity);
    }

    public UserModel getUser(String username) {

        UserEntity userEntity = userRepository.findOneByUsername(username);
        return userEntityToModel(userEntity);
    }

    public UserModel getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findOneByEmail(email);
        return userEntityToModel(userEntity);
    }

    public List<UserModel> getAllUsers() {
        List<UserModel> models = new ArrayList<>();
        Iterable<UserEntity> entities = userRepository.findAll();
        for (UserEntity userEntity : entities) {
            models.add(userEntityToModel(userEntity));
        }
        return models;
    }

    private UserModel userEntityToModel(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        Set<CarModel> cars = carRepositoryImpl.getUserCars(userEntity.getId());
        UserModel model = new UserModel(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(),
                userEntity.getRole(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(),
                userEntity.getLastVisite(), userEntity.getTelephone(), userEntity.getDaysToEvent(), cars);
        return model;
    }

    private UserEntity userModelToEntity(UserModel model) {
        UserEntity entity = new UserEntity(model.getUsername(), model.getPassword(), model.getRole(),
                model.getFirstName(), model.getLastName(), model.getEmail(), model.getLastVisit(), model.getTelephone(),
                model.getDaysToEvent());
        return entity;
    }

}
