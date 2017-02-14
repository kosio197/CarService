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

@Entity(name = "users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private Date lastVisit;
    private String telephone;
    private Integer daysToEvent;
    private Set<CarEntity> userCars;

    public UserEntity() {
        this.userCars = new HashSet<>();
    }

    public UserEntity(String username, String password, String role, String firstName, String lastName, String email,
            Date lastVisite, String telephone, Integer daysToEvent) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.lastVisit = lastVisite;
        this.telephone = telephone;
        this.daysToEvent = daysToEvent;
    }

    public void addCar(CarEntity carEntity) {
        userCars.add(carEntity);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "last_visit_date", nullable = false)
    public Date getLastVisite() {
        return lastVisit;
    }

    public void setLastVisite(Date lastVisite) {
        this.lastVisit = lastVisite;
    }

    @Column(name = "telephone", nullable = false)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "days_to_event", nullable = false)
    public Integer getDaysToEvent() {
        return daysToEvent;
    }

    public void setDaysToEvent(Integer daysToEvent) {
        this.daysToEvent = daysToEvent;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_cars", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
    public Set<CarEntity> getUserCars() {
        return userCars;
    }

    public void setUserCars(Set<CarEntity> userCars) {
        this.userCars = userCars;
    }
}
