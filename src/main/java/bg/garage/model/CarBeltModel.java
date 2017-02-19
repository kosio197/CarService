package bg.garage.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CarBeltModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date changeDate;
    private Integer milage;
    private String beltType;

    public CarBeltModel() {

    }

    public CarBeltModel(Date changeDate, Integer milage, String beltType) {
        super();
        this.changeDate = changeDate;
        this.milage = milage;
        this.beltType = beltType;
    }

    public CarBeltModel(Long id, Date changeDate, Integer milage, String beltType) {
        super();
        this.id = id;
        this.changeDate = changeDate;
        this.milage = milage;
        this.beltType = beltType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Integer getMilage() {
        return milage;
    }

    public void setMilage(Integer milage) {
        this.milage = milage;
    }

    public String getBeltType() {
        return beltType;
    }

    public void setBeltType(String beltType) {
        this.beltType = beltType;
    }

}
