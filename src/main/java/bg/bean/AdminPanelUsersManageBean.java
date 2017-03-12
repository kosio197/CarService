package bg.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import bg.garage.model.CarModel;
import bg.garage.model.UserModel;
import bg.garage.security_service.UserAutenticationService;
import bg.garage.servicesImpl.UserServiceImpl;
import bg.garage.servicesImpl.VehicleServiceImpl;

@ManagedBean(name = "adminPanelUserManageBean")
@ViewScoped
public class AdminPanelUsersManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userServiceImpl}")
    private UserServiceImpl userService;

    @ManagedProperty("#{vehicleServiceImpl}")
    private VehicleServiceImpl vehicleServiceImpl;

    @ManagedProperty("#{userAutenticationService}")
    private UserAutenticationService userAutenticationService;

    @ManagedProperty("#{layoutManageBean}")
    private LayoutManageBean layoutManageBeab;

    private List<UserModel> allUsers;
    private List<UserModel> filteredUsers;
    private List<CarModel> userCars;

    @PostConstruct
    public void init() {
        setAllUsers(userService.getAllUsers());
        layoutManageBeab.setAdminView();
    }

    /*
     * ############### GETTERS AND SETTERS ####################
     */
    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public VehicleServiceImpl getVehicleServiceImpl() {
        return vehicleServiceImpl;
    }

    public void setVehicleServiceImpl(VehicleServiceImpl vehicleServiceImpl) {
        this.vehicleServiceImpl = vehicleServiceImpl;
    }

    public UserAutenticationService getUserAutenticationService() {
        return userAutenticationService;
    }

    public void setUserAutenticationService(UserAutenticationService userAutenticationService) {
        this.userAutenticationService = userAutenticationService;
    }

    public LayoutManageBean getLayoutManageBeab() {
        return layoutManageBeab;
    }

    public void setLayoutManageBeab(LayoutManageBean layoutManageBeab) {
        this.layoutManageBeab = layoutManageBeab;
    }

    public List<UserModel> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<UserModel> allUsers) {
        this.allUsers = allUsers;
    }

    public List<CarModel> getUserCars() {
        return userCars;
    }

    public void setUserCars(List<CarModel> userCars) {
        this.userCars = userCars;
    }

    public List<UserModel> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<UserModel> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }

}
