package bakabakayow.restApi.controller;

import bakabakayow.restApi.dto.LoginRequest;
import bakabakayow.restApi.dto.LoginResponse;
import bakabakayow.restApi.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        String token = jwtIssuer.issuer(1L,request.getEmail(), List.of("USER"));
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }

}
