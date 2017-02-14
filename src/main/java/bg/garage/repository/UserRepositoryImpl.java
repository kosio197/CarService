package bg.garage.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.garage.entity.UserEntity;
import bg.garage.model.UserModel;

@Component
public class UserRepositoryImpl {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserModel userModel) {
        UserEntity userEntity = userModelToEntity(userModel);
        userRepository.save(userEntity);
    }

    public UserModel getUser(String username) {

        UserEntity userEntity = userRepository.findOneByUsername(username);
        return userEntityToModel(userEntity);
    }

    private UserModel userEntityToModel(UserEntity userEntity) {
        UserModel model = new UserModel(userEntity.getUsername(), userEntity.getPassword(), userEntity.getRole(),
                userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getLastVisite(),
                userEntity.getTelephone(), userEntity.getDaysToEvent());
        return model;
    }

    private UserEntity userModelToEntity(UserModel model) {
        UserEntity entity = new UserEntity(model.getUsername(), model.getPassword(), model.getRole(),
                model.getFirstName(), model.getLastName(), model.getEmail(), model.getLastVisit(), model.getTelephone(),
                model.getDaysToEvent());
        return entity;
    }

    public List<UserModel> getAllUsers() {
        List<UserModel> models = new ArrayList<>();
        Iterable<UserEntity> entities = userRepository.findAll();
        for (UserEntity userEntity : entities) {
            models.add(userEntityToModel(userEntity));
        }
        return models;
    }

}
