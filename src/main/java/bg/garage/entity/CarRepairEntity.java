package bg.garage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
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

@Entity(name = "repairs")
public class CarRepairEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date repairDate;
    private Integer currentMilage;
    private String description;
    private String recomendetUpcomingRepair;

    private Set<PictureEntity> repairPictures;
    private Set<PartEntity> parts;

    public CarRepairEntity() {
        this.repairPictures = new HashSet<>();
        this.parts = new HashSet<>();
    }

    public CarRepairEntity(Date repairDate, Integer currentMilage, String description,
            String recomendetUpcomingRepair) {
        this();
        this.repairDate = repairDate;
        this.currentMilage = currentMilage;
        this.description = description;
        this.recomendetUpcomingRepair = recomendetUpcomingRepair;
    }

    public void addPicture(PictureEntity picture) {
        this.repairPictures.add(picture);
    }

    public void addPart(PartEntity partEntity) {
        this.parts.add(partEntity);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "repair_date")
    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    @Column(name = "milage")
    public Integer getCurrentMilage() {
        return currentMilage;
    }

    public void setCurrentMilage(Integer currentMilage) {
        this.currentMilage = currentMilage;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "recomendet_upcoming_repairs")
    public String getRecomendetUpcomingRepair() {
        return recomendetUpcomingRepair;
    }

    public void setRecomendetUpcomingRepair(String recomendetUpcomingRepair) {
        this.recomendetUpcomingRepair = recomendetUpcomingRepair;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "repairs_pictures", joinColumns = @JoinColumn(name = "repair_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"))
    public Set<PictureEntity> getRepairPictures() {
        return repairPictures;
    }

    public void setRepairPictures(Set<PictureEntity> repairPictures) {
        this.repairPictures = repairPictures;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "repairs_parts", joinColumns = @JoinColumn(name = "repair_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "patr_id", referencedColumnName = "id"))
    public Set<PartEntity> getParts() {
        return parts;
    }

    public void setParts(Set<PartEntity> parts) {
        this.parts = parts;
    }

}
