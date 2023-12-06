package bakabakayow.restApi.model;

import bakabakayow.restApi.constants.SportType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "venue")
@ToString(exclude={"venue"})
@Table(name = "fields")
public class Fields implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fieldId;

    private String name;

    @Enumerated(EnumType.STRING)
    private SportType type;

    @ManyToOne
    @JoinColumn(name="venuesId")
    @JsonBackReference
    private Venues venue;

    @OneToMany(mappedBy = "field",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Bookings> bookings;

}
