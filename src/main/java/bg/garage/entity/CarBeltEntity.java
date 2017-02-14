package bg.garage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "car_belts")
public class CarBeltEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date changeDate;
    private Integer milage;
    private String beltType;

    public CarBeltEntity() {

    }

    public CarBeltEntity(Date changeDate, Integer milage, String beltType) {
        this();
        this.changeDate = changeDate;
        this.milage = milage;
        this.beltType = beltType;
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

    @Column(name = "belt_type")
    public String getBeltType() {
        return beltType;
    }

    public void setBeltType(String beltType) {
        this.beltType = beltType;
    }

}
