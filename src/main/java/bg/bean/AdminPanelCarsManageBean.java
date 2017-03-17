package bg.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import bg.garage.model.CarModel;
import bg.garage.model.RepairModel;
import bg.garage.servicesImpl.RepairServiceImpl;
import bg.garage.servicesImpl.UserServiceImpl;
import bg.garage.servicesImpl.VehicleServiceImpl;

@ManagedBean(name = "adminPanelCarsManageBean")
@SessionScoped
public class AdminPanelCarsManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userServiceImpl}")
    private UserServiceImpl userService;

    @ManagedProperty("#{vehicleServiceImpl}")
    private VehicleServiceImpl vehicleServiceImpl;

    @ManagedProperty("#{repairServiceImpl}")
    private RepairServiceImpl repairServiceImpl;

    @ManagedProperty("#{layoutManageBean}")
    private LayoutManageBean layoutManageBean;

    private List<CarModel> allCars;
    private List<RepairModel> currentCarRepairs;

    @PostConstruct
    public void init() {
        setAllCars(vehicleServiceImpl.getAllCars());
        layoutManageBean.setAdminView();
    }

    public String getOwnerName(Long ownerId) {
        return userService.getUserNameById(ownerId);
    }

    public String viewCarRepairs(CarModel car) {
        return "";
    }

    public void editCar(CarModel car) {
        this.vehicleServiceImpl.addCar(car);
    }

    public void deleteCar(CarModel car) {
        this.vehicleServiceImpl.deleteCar(car.getId());
    }

    /*
     * ############### GETARS AND SETARS ####################
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

    public RepairServiceImpl getRepairServiceImpl() {
        return repairServiceImpl;
    }

    public void setRepairServiceImpl(RepairServiceImpl repairServiceImpl) {
        this.repairServiceImpl = repairServiceImpl;
    }

    public LayoutManageBean getLayoutManageBean() {
        return layoutManageBean;
    }

    public void setLayoutManageBean(LayoutManageBean layoutManageBean) {
        this.layoutManageBean = layoutManageBean;
    }

    public List<CarModel> getAllCars() {
        return allCars;
    }

    public void setAllCars(List<CarModel> allCars) {
        this.allCars = allCars;
    }

    public List<RepairModel> getCurrentCarRepairs() {
        return currentCarRepairs;
    }

    public void setCurrentCarRepairs(List<RepairModel> currentCarRepairs) {
        this.currentCarRepairs = currentCarRepairs;
    }
}
