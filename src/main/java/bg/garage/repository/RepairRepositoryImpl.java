package bg.garage.repository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.garage.entity.RepairEntity;
import bg.garage.model.RepairModel;

@Component
public class RepairRepositoryImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private RepairRepository repairRepository;

    public void addRepair(RepairModel model) {
        repairRepository.save(repairModelToEntity(model));
    }

    public Set<RepairModel> findAllByCarId(Long id) {

        Set<RepairModel> repairs = new HashSet<>();

        Iterable<RepairEntity> carRepairs = repairRepository.findAllByCarId(id);

        if (carRepairs != null) {

            for (RepairEntity repairEntity : carRepairs) {
                repairs.add(repairEntityToModel(repairEntity));
            }

        }
        return repairs;
    }

    public void deleteRepair(Long id) {
        repairRepository.delete(id);
    }

    public void deleteRepairsByCar(Long deletedCarId) {
        for (RepairModel model : findAllByCarId(deletedCarId)) {
            deleteRepair(model.getCarId());
        }
    }

    private RepairEntity repairModelToEntity(RepairModel model) {
        RepairEntity entity = new RepairEntity(model.getCarId(), model.getRepairDate(), model.getCurrentMilage(),
                model.getDescription(), model.getRecomendetUpcomingRepair());
        if (model.getId() != null) {
            entity.setId(model.getId());
        }
        return entity;
    }

    private RepairModel repairEntityToModel(RepairEntity entity) {
        RepairModel model = new RepairModel(entity.getId(), entity.getCarId(), entity.getRepairDate(),
                entity.getCurrentMilage(), entity.getDescription(), entity.getRecomendetUpcomingRepair());
        return model;
    }
}
