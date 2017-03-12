package bg.bean;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bg.garage.model.CarModel;
import bg.garage.model.RepairModel;
import bg.garage.model.UserModel;
import bg.garage.security_service.UserAutenticationService;
import bg.garage.servicesImpl.RepairServiceImpl;
import bg.garage.servicesImpl.UserServiceImpl;
import bg.garage.servicesImpl.VehicleServiceImpl;

@ManagedBean(name = "userManageBean", eager = true)
@SessionScoped
public class UserManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userServiceImpl}")
    private UserServiceImpl userService;

    @ManagedProperty("#{vehicleServiceImpl}")
    private VehicleServiceImpl vehicleServiceImpl;

    @ManagedProperty("#{repairServiceImpl}")
    private RepairServiceImpl repairServiceImpl;

    @ManagedProperty("#{userAutenticationService}")
    private UserAutenticationService userAutenticationService;

    @ManagedProperty("#{layoutManageBean}")
    private LayoutManageBean layoutManageBeab;

    private UserModel currentUser;
    private String username;
    private String password;
    private boolean isAutenticated = true;
    private boolean isRefreshed;
    private boolean hasRoleAdmin;

    /*
     * *** Authentication, Login, Logout and edit profile current logged user
     */

    public void login() throws IOException {
        UserModel targetUser = this.userAutenticationService.autenticateUser(username, password);

        if (targetUser != null) {
            this.currentUser = targetUser;

            setHasRoleAdmin(currentUser != null ? currentUser.getRole().equals("ADMIN") : true);
            setRefreshed(true);

            layoutManageBeab.setCurrentUserPageLayout();
            sendRedirect("/page/currentUserView.html");
        } else {
            setAutenticated(false);
        }
    }

    public void logout() throws IOException {
        this.currentUser = null;
        userService.invalidateUserSession();
        setHasRoleAdmin(false);
        sendRedirect("/page/login.html");
    }

    public void editProfil() {
        String error = userAutenticationService.verificateUserProparty(currentUser.getId(), currentUser.getEmail());
        if (error.equals("")) {
            userService.addUser(currentUser);
            setRefreshed(false);
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Неуспешна операция! ", error));
        }
    }

    /*
     * CAR ######################################################## *** Add,
     * Edit and Remove Car from current logged user Cars
     */

    public String addCar(CarModel carModel) {
        vehicleServiceImpl.addCar(carModel);
        refreshCurrentUser();
        return "/page/currentUserView";
    }

    public void editCurrentCar(CarModel currentCar) {
        vehicleServiceImpl.addCar(currentCar);
        refreshCurrentUser();
    }

    public void deleteCurrentCar(Long carId) {
        vehicleServiceImpl.deleteCar(carId);
        refreshCurrentUser();
    }

    public String userLastVisiteDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(currentUser.getLastVisit());
    }

    /*
     * ################################################################ *** Add,
     * Edit and Remove Repair from current Car on logged user Cars
     */

    public String addRepair(RepairModel model) throws IOException {
        repairServiceImpl.addRepair(model);
        refreshCurrentUser();
        return "/page/currentCarView";
    }

    public void editRepair(RepairModel repairModel) throws IOException {
        repairServiceImpl.addRepair(repairModel);
        refreshCurrentUser();
    }

    public void deleteRepair(Long repairId) throws IOException {
        repairServiceImpl.deleteRepair(repairId);
        refreshCurrentUser();
    }

    /*
     * Navigation
     */

    public void userRegistryPageSendRedirect() throws IOException {
        sendRedirect("/page/userRegistry.html");
    }

    public void carRegistryPageSendRedirect() throws IOException {
        setRefreshed(false);
        sendRedirect("/page/carRegistry.html");
    }

    private void sendRedirect(String path) throws IOException {
        String relPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        FacesContext.getCurrentInstance().getExternalContext().redirect(relPath + path);
    }

    /*
     * Refresh data after add or edit
     */
    private void refreshCurrentUser() {
        this.currentUser = userService.getUserByUsername(username);
        setHasRoleAdmin(currentUser != null ? currentUser.getRole().equals("ADMIN") : true);
        setRefreshed(true);
    }

    /*
     * ********** getars and setars ****************************************
     */
    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
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

    public UserModel getCurrentUser() throws IOException {
        if (!isRefreshed) {
            refreshCurrentUser();
        }
        return currentUser;
    }

    public void setCurrentUser(UserModel currentUser) {
        this.currentUser = currentUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAutenticated() {
        return isAutenticated;
    }

    public void setAutenticated(boolean isAutenticated) {
        this.isAutenticated = isAutenticated;
    }

    public boolean isHasRoleAdmin() {
        return hasRoleAdmin;
    }

    public void setHasRoleAdmin(boolean hasRoleAdmin) {
        this.hasRoleAdmin = hasRoleAdmin;
    }

    public boolean isRefreshed() {
        return isRefreshed;
    }

    public void setRefreshed(boolean isRefreshed) {
        this.isRefreshed = isRefreshed;
    }

    public VehicleServiceImpl getVehicleServiceImpl() {
        return vehicleServiceImpl;
    }

    public void setVehicleServiceImpl(VehicleServiceImpl vehicleServiceImpl) {
        this.vehicleServiceImpl = vehicleServiceImpl;
    }

    public RepairServiceImpl getRepairServiceImpl() {
        return repairServiceImpl;
    }

    public void setRepairServiceImpl(RepairServiceImpl repairServiceImpl) {
        this.repairServiceImpl = repairServiceImpl;
    }

}
