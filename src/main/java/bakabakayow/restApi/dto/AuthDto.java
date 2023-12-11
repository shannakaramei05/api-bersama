package bakabakayow.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;

}
