package bakabakayow.restApi.controller;

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
}
