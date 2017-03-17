package bg.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import bg.garage.model.RepairModel;
import bg.garage.servicesImpl.RepairServiceImpl;
import bg.garage.servicesImpl.VehicleServiceImpl;

@ManagedBean(name = "AdminPanelRepairsManageBean")
@ViewScoped
public class AdminPanelRepairsManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{vehicleServiceImpl}")
    private VehicleServiceImpl vehicleServiceImpl;

    @ManagedProperty("#{repairServiceImpl}")
    private RepairServiceImpl repairServiceImpl;

    @ManagedProperty("#{layoutManageBean}")
    private LayoutManageBean layoutManageBeab;

    private RepairModel editedRepair;
    private List<RepairModel> allRepairs;
    private Map<Long, String> repairedCars;

    @PostConstruct
    public void init() {
        setAllRepairs(repairServiceImpl.getAllRepairs());
        this.layoutManageBeab.setAdminView();
        this.repairedCars = new HashMap<>();
    }

    public String tabTitle(RepairModel model) {
        String formatedDate = formattDate(model.getRepairDate());
        String repairedCar = getCarByRepair(model.getCarId());
        return formatedDate + " " + repairedCar;
    }

    public void editRepair(RepairModel repair) {
        this.repairServiceImpl.addRepair(repair);

        FacesMessage msg = new FacesMessage("Repair Edited", repair.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteRepair(Long repairId) {
        this.repairServiceImpl.deleteRepair(repairId);

        FacesMessage msg = new FacesMessage("Repair Deleted", repairId.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private String formattDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(date);
    }

    private String getCarByRepair(Long carId) {
        String car = repairedCars.get(carId);
        if (car == null) {
            car = this.vehicleServiceImpl.getCar(carId).toString();
            repairedCars.put(carId, car);
        }
        return car;
    }

    /*
     * ############### GETTARS AND SETTARS ####################
     */

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

    public LayoutManageBean getLayoutManageBeab() {
        return layoutManageBeab;
    }

    public void setLayoutManageBeab(LayoutManageBean layoutManageBeab) {
        this.layoutManageBeab = layoutManageBeab;
    }

    public RepairModel getEditedRepair() {
        return editedRepair;
    }

    public void setEditedRepair(RepairModel editedRepair) {
        this.editedRepair = editedRepair;
    }

    public List<RepairModel> getAllRepairs() {
        return allRepairs;
    }

    public void setAllRepairs(List<RepairModel> allRepairs) {
        this.allRepairs = allRepairs;
    }
}
