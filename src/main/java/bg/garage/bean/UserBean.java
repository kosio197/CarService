package bg.garage.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bg.garage.model.UserModel;
import bg.garage.security_service.UserAutenticationService;
import bg.garage.servicesImpl.UserServiceImpl;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userServiceImpl}")
    private UserServiceImpl userService;

    @ManagedProperty("#{userAutenticationService}")
    private UserAutenticationService userAutenticationService;

    @ManagedProperty("#{userModel}")
    private UserModel user;

    private boolean skip;
    private String username;
    private String password;
    private boolean notAutenticated;

    public boolean hasAutenticated() {
        return notAutenticated;
    }

    public boolean hasRoleAdmin() {
        return user != null ? user.getRole().equals("ADMIN") : false;
    }

    public void userRegistryPageSendRedirect() throws IOException {
        sendRedirect("/CarService/page/userRegistry.html");
    }

    public void logout() throws IOException {
        this.user = null;
        sendRedirect("/CarService/page/login.html");
    }

    public void login() throws IOException {
        UserModel targetUser = this.userAutenticationService.autenticateUser(username, password);

        if (targetUser != null) {
            this.user = targetUser;
            notAutenticated = false;
            sendRedirect("/CarService/page/currentUserView.html");
        } else {
            notAutenticated = true;
        }
    }

    private void sendRedirect(String path) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(path);
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
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

    public UserAutenticationService getUserAutenticationService() {
        return userAutenticationService;
    }

    public void setUserAutenticationService(UserAutenticationService userAutenticationService) {
        this.userAutenticationService = userAutenticationService;
    }
}
