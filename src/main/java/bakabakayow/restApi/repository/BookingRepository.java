package bakabakayow.restApi.repository;

import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Fields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
    List<Bookings> findByFieldAndPlayDateStartBetween(Fields field, LocalDateTime startDate, LocalDateTime endDate);
}
