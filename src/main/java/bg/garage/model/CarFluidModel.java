package bg.garage.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CarFluidModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date changeDate;
    private Integer milage;
    private String fluideType;

    public CarFluidModel() {

    }

    public CarFluidModel(Date changeDate, Integer milage, String fluideType) {
        super();
        this.changeDate = changeDate;
        this.milage = milage;
        this.fluideType = fluideType;
    }

    public CarFluidModel(Long id, Date changeDate, Integer milage, String fluideType) {
        super();
        this.id = id;
        this.changeDate = changeDate;
        this.milage = milage;
        this.fluideType = fluideType;
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

    public String getFluideType() {
        return fluideType;
    }

    public void setFluideType(String fluideType) {
        this.fluideType = fluideType;
    }

}
