package bg.garage.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import bg.garage.model.CarModel;
import bg.garage.servicesImpl.VehicleServiceImpl;

@ManagedBean(name = "carManageBean")
@ViewScoped
public class CarManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{vehicleServiceImpl}")
    private VehicleServiceImpl vehicleServiceImpl;

    public List<CarModel> getUserCars(long userId) {
        return vehicleServiceImpl.getAllCarsFromUser(userId);
    }

    public void carInfoAndManage(CarModel car) {

    }

}
