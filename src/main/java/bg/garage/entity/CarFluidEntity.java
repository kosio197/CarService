package bg.garage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "car_fluids")
public class CarFluidEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date changeDate;
    private Integer milage;
    private String fluideType;

    public CarFluidEntity() {

    }

    public CarFluidEntity(Date changeDate, Integer milage, String fluideType) {
        this.changeDate = changeDate;
        this.milage = milage;
        this.fluideType = fluideType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "change_date")
    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Basic
    public Integer getMilage() {
        return milage;
    }

    public void setMilage(Integer milage) {
        this.milage = milage;
    }

    @Column(name = "fluid_type")
    public String getFluideType() {
        return fluideType;
    }

    public void setFluideType(String fluideType) {
        this.fluideType = fluideType;
    }

}
