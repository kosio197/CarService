package bg.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import bg.garage.model.CarModel;
import bg.garage.model.RepairModel;

@ManagedBean(name = "repairRegistryBean")
@RequestScoped
public class RepairRegistryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{carManageBean}")
    private CarManageBean carManageBean;

    private Long carId;
    private Date repairDate = new Date();
    private Integer currentMilage;
    private String description;
    private String recomendetUpcomingRepair;

    public String addRepair(CarModel car) throws IOException {
        RepairModel model = new RepairModel(car.getId(), repairDate, currentMilage, description,
                recomendetUpcomingRepair);
        return carManageBean.addRepair(model);
    }

    public void backToCurrentCarView() throws IOException {
        sendRedirect("/page/currentCarView.html");
    }

    private void sendRedirect(String path) throws IOException {
        String relPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        FacesContext.getCurrentInstance().getExternalContext().redirect(relPath + path);
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Integer getCurrentMilage() {
        return currentMilage;
    }

    public void setCurrentMilage(Integer currentMilage) {
        this.currentMilage = currentMilage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecomendetUpcomingRepair() {
        return recomendetUpcomingRepair;
    }

    public void setRecomendetUpcomingRepair(String recomendetUpcomingRepair) {
        this.recomendetUpcomingRepair = recomendetUpcomingRepair;
    }

    public CarManageBean getCarManageBean() {
        return carManageBean;
    }

    public void setCarManageBean(CarManageBean carManageBean) {
        this.carManageBean = carManageBean;
    }

}
