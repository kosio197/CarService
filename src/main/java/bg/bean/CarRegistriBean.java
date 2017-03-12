package bg.bean;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import bg.garage.model.CarModel;

@ManagedBean(name = "carRegistriBean", eager = true)
@ViewScoped
public class CarRegistriBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userManageBean}")
    private UserManageBean userManageBean;

    private Long ownerId;

    private String registrationPlate;
    private String marka;
    private String model;
    private String vin;
    private String engineType;
    private Integer currentMilage;

    private Date lastVisitDate = new Date();

    private Date yearManifacture;
    private String carYearManifacture;

    private Date roadTaxisEndDate;
    private Date anualCheckEndDate;
    private Date liabilityInsuranseEndDate;
    private Date fullInsuranseEndDate;
    private Date vinnetesEndDate;

    public void backToUserView() throws IOException {
        sendRedirect("/page/currentUserView.html");
    }

    public String addCar(Long ownerId) throws IOException {
        CarModel carModel = new CarModel(ownerId, registrationPlate, marka, model, vin, engineType, currentMilage,
                yearManifacture, roadTaxisEndDate, anualCheckEndDate, liabilityInsuranseEndDate, fullInsuranseEndDate,
                vinnetesEndDate, lastVisitDate);
        return userManageBean.addCar(carModel);

    }

    public String carLastVisiteDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        return formatter.format(lastVisitDate);
    }

    private void sendRedirect(String path) throws IOException {
        String relPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        FacesContext.getCurrentInstance().getExternalContext().redirect(relPath + path);
    }

    /*
     * Data Formatter from Car Year Manufacture
     */
    public String getCarYearManifacture() {
        return carYearManifacture;
    }

    public void setCarYearManifacture(String carYearManifacture) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        try {
            this.yearManifacture = formatter.parse(carYearManifacture);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Integer getCurrentMilage() {
        return currentMilage;
    }

    public void setCurrentMilage(Integer currentMilage) {
        this.currentMilage = currentMilage;
    }

    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public Date getYearManifacture() {
        return yearManifacture;
    }

    public void setYearManifacture(Date yearManifacture) {
        this.yearManifacture = yearManifacture;
    }

    public Date getRoadTaxisEndDate() {
        return roadTaxisEndDate;
    }

    public void setRoadTaxisEndDate(Date roadTaxisEndDate) {
        this.roadTaxisEndDate = roadTaxisEndDate;
    }

    public Date getAnualCheckEndDate() {
        return anualCheckEndDate;
    }

    public void setAnualCheckEndDate(Date anualCheckEndDate) {
        this.anualCheckEndDate = anualCheckEndDate;
    }

    public Date getLiabilityInsuranseEndDate() {
        return liabilityInsuranseEndDate;
    }

    public void setLiabilityInsuranseEndDate(Date liabilityInsuranseEndDate) {
        this.liabilityInsuranseEndDate = liabilityInsuranseEndDate;
    }

    public Date getFullInsuranseEndDate() {
        return fullInsuranseEndDate;
    }

    public void setFullInsuranseEndDate(Date fullInsuranseEndDate) {
        this.fullInsuranseEndDate = fullInsuranseEndDate;
    }

    public Date getVinnetesEndDate() {
        return vinnetesEndDate;
    }

    public void setVinnetesEndDate(Date vinnetesEndDate) {
        this.vinnetesEndDate = vinnetesEndDate;
    }

    public UserManageBean getUserManageBean() {
        return userManageBean;
    }

    public void setUserManageBean(UserManageBean userManageBean) {
        this.userManageBean = userManageBean;
    }

}
