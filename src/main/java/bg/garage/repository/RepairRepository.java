package bg.garage.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bg.garage.entity.RepairEntity;

@Repository
public interface RepairRepository extends CrudRepository<RepairEntity, Long> {

    @Query(value = "SELECT r FROM repairs r WHERE r.carId =:carId")
    Iterable<RepairEntity> findAllByCarId(@Param("carId") Long carId);

}
