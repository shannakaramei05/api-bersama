package bakabakayow.restApi.repository;

import bakabakayow.restApi.model.Fields;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FieldRepository extends JpaRepository<Fields,Long> {
    Optional<Fields> findByName(String name);
}
