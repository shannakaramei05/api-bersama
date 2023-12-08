package bakabakayow.restApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "play_date_start")
    private LocalDateTime playDateStart;

    @Column(name = "play_date_end")
    private LocalDateTime playDateEnd;

    @ManyToMany(mappedBy = "bookings")
    private List<Users> registeredUser;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Fields field;
}
