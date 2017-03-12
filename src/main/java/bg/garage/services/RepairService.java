package bg.garage.services;

import java.util.List;

import bg.garage.model.RepairModel;

public interface RepairService {

    List<RepairModel> getAllRepairs();

    void addRepair(RepairModel model);

    void deleteRepair(Long repairId);

    List<RepairModel> findAllByCarId(Long id);

    void deleteRepairsByCar(Long deletedCarId);

}
