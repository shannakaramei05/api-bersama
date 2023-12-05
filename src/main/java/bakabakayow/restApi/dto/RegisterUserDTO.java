package bakabakayow.restApi.dto;

import bakabakayow.restApi.constants.UserRole;
import lombok.Data;

@Data
public class RegisterUserDTO {
    private String email;
    private String password;
    private UserRole role;
}
