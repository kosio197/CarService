package bg.garage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name = "cars")
public class CarEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
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

    private CarFluidEntity engineOil;
    private CarFluidEntity transmisionOil;
    private CarFluidEntity differentialOil;
    private CarFluidEntity hidraulicOil;
    private CarFluidEntity breakFluid;
    private CarFluidEntity antifreeze;
    private CarFluidEntity refrigerant;

    private CarBeltEntity timingBelt;
    private Set<CarBeltEntity> accessoaryBelt;

    private Set<CarRepairEntity> repairs;

    public CarEntity() {
        this.accessoaryBelt = new HashSet<>();
        this.repairs = new HashSet<>();
    }

    public CarEntity(String registrationPlate, String marka, String model, Date yearManifacture, String engineType,
            Integer currentMilage, Date roadTaxisEndDate, Date anualCheckEndDate, Date liabilityInsuranseEndDate,
            Date fullInsuranseEndDate, Date vinnetesEndDate, CarFluidEntity engineOil, CarFluidEntity transmisionOil,
            CarFluidEntity differentialOil, CarFluidEntity hidraulicOil, CarFluidEntity breakFluid,
            CarFluidEntity antifreeze, CarFluidEntity refrigerant, CarBeltEntity timingBelt,
            Set<CarBeltEntity> accessoaryBelt) {

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
    }

    public void addRepair(CarRepairEntity carRepairEntity) {
        this.repairs.add(carRepairEntity);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pictures_id")
    public PictureEntity getPictures() {
        return pictures;
    }

    public void setPictures(PictureEntity pictures) {
        this.pictures = pictures;
    }

    @Column(name = "registration_plate", nullable = false)
    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    @Column(name = "marka", nullable = false)
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "year_manufacture", nullable = false)
    public Date getYearManifacture() {
        return yearManifacture;
    }

    public void setYearManifacture(Date yearManifacture) {
        this.yearManifacture = yearManifacture;
    }

    @Column(name = "engine_type", nullable = false)
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Column(name = "current_milage", nullable = false)
    public Integer getCurrentMilage() {
        return currentMilage;
    }

    public void setCurrentMilage(Integer currentMilage) {
        this.currentMilage = currentMilage;
    }

    @Column(name = "road_taxis_end_date")
    public Date getRoadTaxisEndDate() {
        return roadTaxisEndDate;
    }

    public void setRoadTaxisEndDate(Date roadTaxisEndDate) {
        this.roadTaxisEndDate = roadTaxisEndDate;
    }

    @Column(name = "annual_check_end_date")
    public Date getAnualCheckEndDate() {
        return anualCheckEndDate;
    }

    public void setAnualCheckEndDate(Date anualCheckEndDate) {
        this.anualCheckEndDate = anualCheckEndDate;
    }

    @Column(name = "liability_insurances_end_date")
    public Date getLiabilityInsuranseEndDate() {
        return liabilityInsuranseEndDate;
    }

    public void setLiabilityInsuranseEndDate(Date liabilityInsuranseEndDate) {
        this.liabilityInsuranseEndDate = liabilityInsuranseEndDate;
    }

    @Column(name = "full_insurances_end_date")
    public Date getFullInsuranseEndDate() {
        return fullInsuranseEndDate;
    }

    public void setFullInsuranseEndDate(Date fullInsuranseEndDate) {
        this.fullInsuranseEndDate = fullInsuranseEndDate;
    }

    @Column(name = "vinettes__end_date")
    public Date getVinnetesEndDate() {
        return vinnetesEndDate;
    }

    public void setVinnetesEndDate(Date vinnetesEndDate) {
        this.vinnetesEndDate = vinnetesEndDate;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_oil_id")
    public CarFluidEntity getEngineOil() {
        return engineOil;
    }

    public void setEngineOil(CarFluidEntity engineOil) {
        this.engineOil = engineOil;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "transmision_oil_id")
    public CarFluidEntity getTransmisionOil() {
        return transmisionOil;
    }

    public void setTransmisionOil(CarFluidEntity transmisionOil) {
        this.transmisionOil = transmisionOil;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "differential_oil_id")
    public CarFluidEntity getDifferentialOil() {
        return differentialOil;
    }

    public void setDifferentialOil(CarFluidEntity differentialOil) {
        this.differentialOil = differentialOil;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hidravlic_oil_id")
    public CarFluidEntity getHidraulicOil() {
        return hidraulicOil;
    }

    public void setHidraulicOil(CarFluidEntity hidraulicOil) {
        this.hidraulicOil = hidraulicOil;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "break_fluid_id")
    public CarFluidEntity getBreakFluid() {
        return breakFluid;
    }

    public void setBreakFluid(CarFluidEntity breakFluid) {
        this.breakFluid = breakFluid;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "antifreeze_id")
    public CarFluidEntity getAntifreeze() {
        return antifreeze;
    }

    public void setAntifreeze(CarFluidEntity antifreeze) {
        this.antifreeze = antifreeze;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "refrigerant_id")
    public CarFluidEntity getRefrigerant() {
        return refrigerant;
    }

    public void setRefrigerant(CarFluidEntity refrigerant) {
        this.refrigerant = refrigerant;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "timing_belt_id")
    public CarBeltEntity getTimingBelt() {
        return timingBelt;
    }

    public void setTimingBelt(CarBeltEntity timingBelt) {
        this.timingBelt = timingBelt;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "cars_car_belts", joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "car_belts_id", referencedColumnName = "id"))
    public Set<CarBeltEntity> getAccessoaryBelt() {
        return accessoaryBelt;
    }

    public void setAccessoaryBelt(Set<CarBeltEntity> accessoaryBelt) {
        this.accessoaryBelt = accessoaryBelt;
    }

    @ManyToMany
    @JoinTable(name = "cars_repairs", joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "repair_id", referencedColumnName = "id"))
    public Set<CarRepairEntity> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<CarRepairEntity> repairs) {
        this.repairs = repairs;
    }

}
