package bakabakayow.restApi.dto;

import bakabakayow.restApi.model.Fields;
import bakabakayow.restApi.model.Users;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenuesDTO {

    private String name;
    private String phone;
    private String address;
    private Users user;
    private List<Fields> fields;

}
