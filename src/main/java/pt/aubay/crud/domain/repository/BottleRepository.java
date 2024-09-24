package pt.aubay.crud.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.aubay.crud.domain.model.Bottle;

@Repository
public interface BottleRepository extends JpaRepository<Bottle,String> {
}
