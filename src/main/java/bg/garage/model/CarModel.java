package bg.garage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("carModel")
public class CarModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long ownerId;

    private String registrationPlate;
    private String marka;
    private String model;
    private String vin;
    private String engineType;
    private Integer currentMilage;

    private Date lastVisitDate = new Date();

    private Date yearManifacture;
    private Date roadTaxisEndDate;
    private Date anualCheckEndDate;
    private Date liabilityInsuranseEndDate;
    private Date fullInsuranseEndDate;
    private Date vinnetesEndDate;

    private Set<RepairModel> repairs = new HashSet<>();

    public CarModel() {

    }

    public CarModel(Long ownerId, String registrationPlate, String marka, String model, String vin, String engineType,
            Integer currentMilage, Date yearManifacture, Date roadTaxisEndDate, Date anualCheckEndDate,
            Date liabilityInsuranseEndDate, Date fullInsuranseEndDate, Date vinnetesEndDate, Date lastVisitDate) {
        this();
        this.ownerId = ownerId;
        this.registrationPlate = registrationPlate;
        this.marka = marka;
        this.model = model;
        this.vin = vin;
        this.engineType = engineType;
        this.currentMilage = currentMilage;
        this.yearManifacture = yearManifacture;
        this.roadTaxisEndDate = roadTaxisEndDate;
        this.anualCheckEndDate = anualCheckEndDate;
        this.liabilityInsuranseEndDate = liabilityInsuranseEndDate;
        this.fullInsuranseEndDate = fullInsuranseEndDate;
        this.vinnetesEndDate = vinnetesEndDate;
        this.lastVisitDate = lastVisitDate;
    }

    public CarModel(Long id, Long ownerId, String registrationPlate, String marka, String model, String vin,
            String engineType, Integer currentMilage, Date yearManifacture, Date roadTaxisEndDate,
            Date anualCheckEndDate, Date liabilityInsuranseEndDate, Date fullInsuranseEndDate, Date vinnetesEndDate,
            Date lastVisitDate, Set<RepairModel> repairs) {
        this();
        this.id = id;
        this.ownerId = ownerId;
        this.registrationPlate = registrationPlate;
        this.marka = marka;
        this.model = model;
        this.vin = vin;
        this.engineType = engineType;
        this.currentMilage = currentMilage;
        this.yearManifacture = yearManifacture;
        this.roadTaxisEndDate = roadTaxisEndDate;
        this.anualCheckEndDate = anualCheckEndDate;
        this.liabilityInsuranseEndDate = liabilityInsuranseEndDate;
        this.fullInsuranseEndDate = fullInsuranseEndDate;
        this.vinnetesEndDate = vinnetesEndDate;
        this.lastVisitDate = lastVisitDate;
        this.repairs = repairs;
    }

    public void addRepair(RepairModel repair) {
        this.repairs.add(repair);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<RepairModel> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<RepairModel> repairs) {
        this.repairs = repairs;
    }

    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

}
