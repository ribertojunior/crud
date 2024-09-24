package pt.aubay.crud.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.aubay.crud.domain.model.Cap;

public interface CapRepository extends JpaRepository<Cap, String> {
}
