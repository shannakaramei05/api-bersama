package bakabakayow.restApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_has_booking")
public class UsersHasBooking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    @Id
    @ManyToOne
    @JoinColumn(name = "bookings_id")
    private Bookings booking;
}
