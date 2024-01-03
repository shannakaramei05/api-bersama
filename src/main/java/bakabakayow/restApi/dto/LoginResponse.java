package bakabakayow.restApi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class LoginResponse {

    private final String accessToken;
}
