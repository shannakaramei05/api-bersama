package bakabakayow.restApi.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;

}
