package bakabakayow.restApi.controller;

import bakabakayow.restApi.constants.UserRole;
import bakabakayow.restApi.dto.AuthDto;
import bakabakayow.restApi.dto.RegisterUserDTO;
import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Users;
import bakabakayow.restApi.services.AuthorizationService;
import bakabakayow.restApi.services.UserService;
import bakabakayow.restApi.utils.SetResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    private AuthorizationService authorizationService;

    @GetMapping("/users")
    public ResponseEntity<Response<List<Users>>> getAllUsers() {
        Response<List<Users>> response = userService.getAllUser();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-user")
    public ResponseEntity<Response<?>> createNewUser(@RequestBody RegisterUserDTO registerUserDTO) {
        Response<?> response = userService.createNewUser(registerUserDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{role}")
    public ResponseEntity<Response<List<Users>>> usersByRole(@PathVariable UserRole role) {
        return ResponseEntity.ok(userService.getUserByRole(role));
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLoginHandler(@RequestBody AuthDto authDto) {
        Response<Users> user = authorizationService.login(authDto);
        return new ResponseEntity<>(authDto.getEmail(), HttpStatus.OK);
    }
}
