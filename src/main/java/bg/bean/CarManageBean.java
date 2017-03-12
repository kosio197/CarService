package bg.bean;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bg.garage.model.CarModel;
import bg.garage.model.RepairModel;
import bg.garage.servicesImpl.RepairServiceImpl;

@ManagedBean(name = "carManageBean", eager = true)
@SessionScoped
public class CarManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userManageBean}")
    private UserManageBean userManageBean;

    @ManagedProperty("#{layoutManageBean}")
    private LayoutManageBean layoutManageBeab;

    @ManagedProperty("#{repairServiceImpl}")
    private RepairServiceImpl repairServiceImpl;

    private CarModel currentCar;
    private List<CarModel> userCars;
    private String carYearManifacture;

    /*
     * Current car managed function
     */

    public void editCurrentCar() throws IOException {
        userManageBean.editCurrentCar(currentCar);
        refreshData();
    }

    public String deleteCurrentCar() throws IOException {
        userManageBean.deleteCurrentCar(currentCar.getId());
        refreshData();
        return "/page/currentUserView";
    }

    public String currentCarLastVisiteDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(currentCar.getLastVisitDate());
    }

    /*
     * Data Formatter from Car Year Manufacture
     */

    public String getCarYearManifacture() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        this.carYearManifacture = formatter.format(currentCar.getYearManifacture());
        return carYearManifacture;
    }

    public void setCarYearManifacture(String carYearManifacture) {
        this.carYearManifacture = carYearManifacture;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        try {
            currentCar.setYearManifacture(formatter.parse(carYearManifacture));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * Current car repair managed function
     */

    public String addRepair(RepairModel model) throws IOException {
        String redirect = userManageBean.addRepair(model);
        refreshData();
        return redirect;
    }

    public void editRepair(RepairModel repairModel) throws IOException {
        userManageBean.editRepair(repairModel);
        refreshData();

    }

    public String deleteRepair(Long repairId) throws IOException {
        userManageBean.deleteRepair(repairId);
        refreshData();
        return "/page/currentCarView";
    }

    public String currentRepairLastVisiteDate(RepairModel model) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(model.getRepairDate());
    }

    /*
     * Button navigation manage function
     */

    public void addNewRepair() throws IOException {
        sendRedirect("/page/repairRegistry.html");
    }

    public void carInfoAndManage(CarModel car) throws IOException {
        setCurrentCar(car);
        // Set Layout Parameters if is needed!!!!!!!!!!!!
        currentCar.setCarRepairs(this.repairServiceImpl.findAllByCarId(car.getId()));
        sendRedirect("/page/currentCarView.html");
    }

    public void backToUserView() throws IOException {
        sendRedirect("/page/currentUserView.html");
    }

    private void sendRedirect(String path) throws IOException {
        String relPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        FacesContext.getCurrentInstance().getExternalContext().redirect(relPath + path);
    }

    /*
     * Getars and Setars
     */

    private void refreshData() throws IOException {
        for (CarModel carModel : getUserCars()) {
            if (carModel.getId() == currentCar.getId()) {
                currentCar = carModel;
                break;
            }
        }
    }

    /*
     * Getars and Setars
     */

    public CarModel getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(CarModel currentCar) {
        this.currentCar = currentCar;
    }

    public List<CarModel> getUserCars() throws IOException {
        this.userCars = userManageBean.getCurrentUser().getUserCars();
        return userCars;
    }

    public void setUserCars(List<CarModel> userCars) {
        this.userCars = userCars;
    }

    public LayoutManageBean getLayoutManageBeab() {
        return layoutManageBeab;
    }

    public void setLayoutManageBeab(LayoutManageBean layoutManageBeab) {
        this.layoutManageBeab = layoutManageBeab;
    }

    public UserManageBean getUserManageBean() {
        return userManageBean;
    }

    public void setUserManageBean(UserManageBean userManageBean) {
        this.userManageBean = userManageBean;
    }

    public RepairServiceImpl getRepairServiceImpl() {
        return repairServiceImpl;
    }

    public void setRepairServiceImpl(RepairServiceImpl repairServiceImpl) {
        this.repairServiceImpl = repairServiceImpl;
    }

}
