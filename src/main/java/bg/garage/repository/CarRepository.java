package bg.garage.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bg.garage.entity.CarEntity;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {

    @Query(value = "select c from cars as c where c.ownerId =:userId")
    Set<CarEntity> findByOwnerId(@Param("userId") Long userId);
}
