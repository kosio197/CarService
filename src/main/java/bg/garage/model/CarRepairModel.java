package bg.garage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class CarRepairModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date repairDate;
    private Integer currentMilage;
    private String description;
    private String recomendetUpcomingRepair;

    private Set<PictureModel> repairPictures;
    private Set<PartModel> parts;

    public CarRepairModel() {

    }

    public CarRepairModel(Date repairDate, Integer currentMilage, String description, String recomendetUpcomingRepair) {
        super();
        this.repairDate = repairDate;
        this.currentMilage = currentMilage;
        this.description = description;
        this.recomendetUpcomingRepair = recomendetUpcomingRepair;
    }

    public CarRepairModel(Long id, Date repairDate, Integer currentMilage, String description,
            String recomendetUpcomingRepair, Set<PictureModel> repairPictures, Set<PartModel> parts) {
        super();
        this.id = id;
        this.repairDate = repairDate;
        this.currentMilage = currentMilage;
        this.description = description;
        this.recomendetUpcomingRepair = recomendetUpcomingRepair;
        this.repairPictures = repairPictures;
        this.parts = parts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<PictureModel> getRepairPictures() {
        return repairPictures;
    }

    public void setRepairPictures(Set<PictureModel> repairPictures) {
        this.repairPictures = repairPictures;
    }

    public Set<PartModel> getParts() {
        return parts;
    }

    public void setParts(Set<PartModel> parts) {
        this.parts = parts;
    }
}
