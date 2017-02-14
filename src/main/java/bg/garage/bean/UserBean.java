package bg.garage.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FlowEvent;

import bg.garage.model.UserModel;
import bg.garage.servicesImpl.UserServiceImpl;

@ManagedBean(name = "userWizard")
@SessionScoped
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{userServiceImpl}")
    private UserServiceImpl userService;

    @ManagedProperty("#{userModel}")
    private UserModel user;

    private boolean skip;

    public void save() {
        userService.addUser(user);
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; // reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public boolean hasRoleAdmin() {

        return user.getRole().equals("ADMIN");
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

    HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
            .getRequest();

    @PostConstruct
    public HttpServletRequest getHttpServletRequest() {
        httpServletRequest.getSession().setAttribute("name", "null");
        return httpServletRequest;
    }
}
