package bakabakayow.restApi.controller;

import bakabakayow.restApi.constants.UserRole;
import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Users;
import bakabakayow.restApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-data")
    public ResponseEntity<Response<List<Users>>> getAllUsers() {
        Response<List<Users>> response = userService.getAllUser();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-user")
    public ResponseEntity<Response<?>> createNewUser(@RequestHeader(value = "x-auth-user-id") @RequestBody Integer user_id, String password, String email, UserRole role) {
        Response<?> response = userService.createNewUser(user_id,email,password,role);
        return ResponseEntity.ok(response);
    }
}
