package bg.garage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;

import bg.garage.entity.PictureEntity;

@Component
public class CarModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private PictureEntity pictures;
    private String registrationPlate;
    private String marka;
    private String model;
    private Date yearManifacture;
    private String engineType;
    private Integer currentMilage;

    private Date roadTaxisEndDate;
    private Date anualCheckEndDate;
    private Date liabilityInsuranseEndDate;
    private Date fullInsuranseEndDate;
    private Date vinnetesEndDate;

    private CarFluidModel engineOil;
    private CarFluidModel transmisionOil;
    private CarFluidModel differentialOil;
    private CarFluidModel hidraulicOil;
    private CarFluidModel breakFluid;
    private CarFluidModel antifreeze;
    private CarFluidModel refrigerant;

    private CarBeltModel timingBelt;
    private Set<CarBeltModel> accessoaryBelt;

    private Set<CarRepairModel> repairs;

    public CarModel() {

    }

    // From UI
    public CarModel(String registrationPlate, String marka, String model, Date yearManifacture, String engineType,
            Integer currentMilage, Date roadTaxisEndDate, Date anualCheckEndDate, Date liabilityInsuranseEndDate,
            Date fullInsuranseEndDate, Date vinnetesEndDate) {
        super();
        this.registrationPlate = registrationPlate;
        this.marka = marka;
        this.model = model;
        this.yearManifacture = yearManifacture;
        this.engineType = engineType;
        this.currentMilage = currentMilage;
        this.roadTaxisEndDate = roadTaxisEndDate;
        this.anualCheckEndDate = anualCheckEndDate;
        this.liabilityInsuranseEndDate = liabilityInsuranseEndDate;
        this.fullInsuranseEndDate = fullInsuranseEndDate;
        this.vinnetesEndDate = vinnetesEndDate;
    }

    // From Repository
    public CarModel(Long id, Long userId, PictureEntity pictures, String registrationPlate, String marka, String model,
            Date yearManifacture, String engineType, Integer currentMilage, Date roadTaxisEndDate,
            Date anualCheckEndDate, Date liabilityInsuranseEndDate, Date fullInsuranseEndDate, Date vinnetesEndDate,
            CarFluidModel engineOil, CarFluidModel transmisionOil, CarFluidModel differentialOil,
            CarFluidModel hidraulicOil, CarFluidModel breakFluid, CarFluidModel antifreeze, CarFluidModel refrigerant,
            CarBeltModel timingBelt, Set<CarBeltModel> accessoaryBelt, Set<CarRepairModel> repairs) {
        super();
        this.id = id;
        this.userId = userId;
        this.pictures = pictures;
        this.registrationPlate = registrationPlate;
        this.marka = marka;
        this.model = model;
        this.yearManifacture = yearManifacture;
        this.engineType = engineType;
        this.currentMilage = currentMilage;
        this.roadTaxisEndDate = roadTaxisEndDate;
        this.anualCheckEndDate = anualCheckEndDate;
        this.liabilityInsuranseEndDate = liabilityInsuranseEndDate;
        this.fullInsuranseEndDate = fullInsuranseEndDate;
        this.vinnetesEndDate = vinnetesEndDate;
        this.engineOil = engineOil;
        this.transmisionOil = transmisionOil;
        this.differentialOil = differentialOil;
        this.hidraulicOil = hidraulicOil;
        this.breakFluid = breakFluid;
        this.antifreeze = antifreeze;
        this.refrigerant = refrigerant;
        this.timingBelt = timingBelt;
        this.accessoaryBelt = accessoaryBelt;
        this.repairs = repairs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PictureEntity getPictures() {
        return pictures;
    }

    public void setPictures(PictureEntity pictures) {
        this.pictures = pictures;
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

    public Date getYearManifacture() {
        return yearManifacture;
    }

    public void setYearManifacture(Date yearManifacture) {
        this.yearManifacture = yearManifacture;
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

    public CarFluidModel getEngineOil() {
        return engineOil;
    }

    public void setEngineOil(CarFluidModel engineOil) {
        this.engineOil = engineOil;
    }

    public CarFluidModel getTransmisionOil() {
        return transmisionOil;
    }

    public void setTransmisionOil(CarFluidModel transmisionOil) {
        this.transmisionOil = transmisionOil;
    }

    public CarFluidModel getDifferentialOil() {
        return differentialOil;
    }

    public void setDifferentialOil(CarFluidModel differentialOil) {
        this.differentialOil = differentialOil;
    }

    public CarFluidModel getHidraulicOil() {
        return hidraulicOil;
    }

    public void setHidraulicOil(CarFluidModel hidraulicOil) {
        this.hidraulicOil = hidraulicOil;
    }

    public CarFluidModel getBreakFluid() {
        return breakFluid;
    }

    public void setBreakFluid(CarFluidModel breakFluid) {
        this.breakFluid = breakFluid;
    }

    public CarFluidModel getAntifreeze() {
        return antifreeze;
    }

    public void setAntifreeze(CarFluidModel antifreeze) {
        this.antifreeze = antifreeze;
    }

    public CarFluidModel getRefrigerant() {
        return refrigerant;
    }

    public void setRefrigerant(CarFluidModel refrigerant) {
        this.refrigerant = refrigerant;
    }

    public CarBeltModel getTimingBelt() {
        return timingBelt;
    }

    public void setTimingBelt(CarBeltModel timingBelt) {
        this.timingBelt = timingBelt;
    }

    public Set<CarBeltModel> getAccessoaryBelt() {
        return accessoaryBelt;
    }

    public void setAccessoaryBelt(Set<CarBeltModel> accessoaryBelt) {
        this.accessoaryBelt = accessoaryBelt;
    }

    public Set<CarRepairModel> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<CarRepairModel> repairs) {
        this.repairs = repairs;
    }

}
