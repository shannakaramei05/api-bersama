package bakabakayow.restApi.repository;

import bakabakayow.restApi.model.Venues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venues,Long> {
}
