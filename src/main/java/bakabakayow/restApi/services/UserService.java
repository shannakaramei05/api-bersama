package bakabakayow.restApi.services;

import bakabakayow.restApi.constants.UserRole;
import bakabakayow.restApi.dto.RegisterUserDTO;
import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Users;
import bakabakayow.restApi.repository.UserRepository;
import bakabakayow.restApi.utils.SetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Response<List<Users>> getAllUser() {
        return SetResponse.setStatusMessageSuccess(userRepository.findAll());
    }

    public Response<List<Users>> getUserByRole(UserRole role) {
        return SetResponse.setStatusMessageSuccess(userRepository.findUsersByRole(role));
    }

    public Response<?> createNewUser (RegisterUserDTO req) {
        Users newUser = new Users();
        Optional<Users> user = userRepository.findUserByEmail(req.getEmail());

        if(user.isPresent()) {
            return SetResponse.setResponseEmailAreadyUsed();
        }else {
            String encPassword = passwordEncoder.encode(req.getPassword());
            newUser.setEmail(req.getEmail());
            newUser.setPassword(encPassword);
            newUser.setRole(req.getRole());
            userRepository.save(newUser);
            return SetResponse.setStatusMessageSuccess(newUser.getEmail());
        }

    }
}
