package bakabakayow.restApi.repository;

import bakabakayow.restApi.model.Fields;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Fields,Long> {
}
