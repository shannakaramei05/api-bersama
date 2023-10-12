package bakabakayow.restApi.model;

import bakabakayow.restApi.constants.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer userId;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String token;

    private String refreshToken;

    private long createdDate;

    @OneToMany(mappedBy = "user")
    private List<Bookings> bookings;

    @OneToMany(mappedBy = "user")
    private List<Venues> venues;

    @OneToMany(mappedBy = "user")
    private List<UsersHasBooking> usersHasBookings;

}
