package bg.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bg.garage.model.CarModel;
import bg.garage.model.UserModel;
import bg.garage.security_service.UserAutenticationService;
import bg.garage.servicesImpl.UserServiceImpl;
import bg.garage.servicesImpl.VehicleServiceImpl;

@ManagedBean(name = "adminPanelUserManageBean")
@SessionScoped
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

    @ManagedProperty("#{adminPanelCarsManageBean}")
    private AdminPanelCarsManageBean adminPanelCarsManageBean;

    private List<UserModel> allUsers;
    private List<CarModel> userCars;

    @PostConstruct
    public void init() {
        setAllUsers(userService.getAllUsers());
        layoutManageBeab.setAdminView();
    }

    public void editUser(UserModel userModel) {
        userService.addUser(userModel);
    }

    public void deleteUser(UserModel userModel) {
        userService.deleteUser(userModel.getId());
    }

    /*
     * Navigation
     */

    public void manageCars(UserModel userModel) throws IOException {
        adminPanelCarsManageBean.setAllCars(vehicleServiceImpl.getUserCars(userModel.getId()));
        sendRedirect("/page/adminAllCarsView.html");
    }

    public void adminAllCarsPageSendRedirect() throws IOException {
        adminPanelCarsManageBean.setAllCars(vehicleServiceImpl.getAllCars());
        sendRedirect("/page/adminAllCarsView.html");
    }

    private void sendRedirect(String path) throws IOException {
        String relPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        FacesContext.getCurrentInstance().getExternalContext().redirect(relPath + path);
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

    public AdminPanelCarsManageBean getAdminPanelCarsManageBean() {
        return adminPanelCarsManageBean;
    }

    public void setAdminPanelCarsManageBean(AdminPanelCarsManageBean adminPanelCarsManageBean) {
        this.adminPanelCarsManageBean = adminPanelCarsManageBean;
    }

}
