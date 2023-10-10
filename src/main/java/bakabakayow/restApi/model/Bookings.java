package bakabakayow.restApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Bookings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "play_date_start")
    private LocalDateTime playDateStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "play_date_end")
    private LocalDateTime playDateEnd;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id_booking")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Fields field;

    @OneToMany(mappedBy = "booking")
    private List<UsersHasBooking> usersHasBookings;
}
