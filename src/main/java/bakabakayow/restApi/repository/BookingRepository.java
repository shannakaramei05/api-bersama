package bakabakayow.restApi.repository;

import bakabakayow.restApi.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
    List<Bookings> findByField_Venue_VenueIdAndPlayDateStartBetween(Long id, LocalDateTime start, LocalDateTime end);
}
