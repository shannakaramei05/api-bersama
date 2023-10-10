package bakabakayow.restApi.repository;

import bakabakayow.restApi.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
}
