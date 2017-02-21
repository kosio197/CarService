package bg.garage.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import bg.garage.model.UserModel;
import bg.garage.security_service.UserAutenticationService;
import bg.garage.servicesImpl.UserServiceImpl;

@ManagedBean(name = "userRegistryBean")
@RequestScoped
public class UserRegistryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userServiceImpl}")
    private UserServiceImpl userService;

    @ManagedProperty("#{userAutenticationService}")
    private UserAutenticationService userAutenticationService;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private Integer daysToEvent;

    private String propertyErrorMesage = "";

    public boolean hasError() {
        return !propertyErrorMesage.equals("");
    }

    public void addUser() throws IOException {
        propertyErrorMesage = userAutenticationService.verificateUserProparty(username, email, password, firstName,
                lastName, telephone, daysToEvent);
        if (propertyErrorMesage.equals("")) {
            addNewUser();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(propertyErrorMesage));
        }
    }

    private void addNewUser() throws IOException {
        UserModel user = new UserModel(username, password, firstName, lastName, email, telephone, daysToEvent);
        userService.addUser(user);
        sendRedirect("/CarService/page/login.html");
    }

    private void sendRedirect(String path) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(path);
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public UserAutenticationService getUserAutenticationService() {
        return userAutenticationService;
    }

    public void setUserAutenticationService(UserAutenticationService userAutenticationService) {
        this.userAutenticationService = userAutenticationService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getDaysToEvent() {
        return daysToEvent;
    }

    public void setDaysToEvent(Integer daysToEvent) {
        this.daysToEvent = daysToEvent;
    }

    public String getPropertyErrorMesage() {
        return propertyErrorMesage;
    }

    public void setPropertyErrorMesage(String propertyErrorMesage) {
        this.propertyErrorMesage = propertyErrorMesage;
    }

}
