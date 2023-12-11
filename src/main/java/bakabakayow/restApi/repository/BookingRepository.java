package bakabakayow.restApi.repository;

import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Fields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
   @Query("SELECT b FROM Bookings b WHERE b.id = :id AND DATE(b.playDateStart) = DATE(:playDateStart)")
   List<Bookings> getBookingsByIdAndPlayDateStart(@Param("id") Long id,
                                                  @Param("playDateStart") LocalDateTime playDateStart);
}
