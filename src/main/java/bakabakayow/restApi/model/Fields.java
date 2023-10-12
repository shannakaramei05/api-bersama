package bakabakayow.restApi.model;

import bakabakayow.restApi.constants.SportType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fields")
public class Fields implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldId;

    private String name;

    @Enumerated(EnumType.STRING)
    private SportType type;

    @ManyToOne
    @JoinColumn(name="venues_id")
    private Venues venue;

    @OneToMany(mappedBy = "field")
    private List<Bookings> bookings;

}
