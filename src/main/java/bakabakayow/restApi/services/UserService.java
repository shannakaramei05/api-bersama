package bakabakayow.restApi.services;

import bakabakayow.restApi.constants.UserRole;
import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Users;
import bakabakayow.restApi.repository.UserRepository;
import bakabakayow.restApi.utils.SetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Response<?> createNewUser (Integer userId, String email, String password, UserRole role) {
        long unixTime = System.currentTimeMillis()/1000L;
        Users newUser = new Users();
        Optional<Users> user = userRepository.findUserByEmail(email);

        if(user.isPresent()) {
            return SetResponse.setResponseEmailAreadyUsed();
        }else {
            String encPassword = passwordEncoder.encode(password);
            newUser.setUserId(userId);
            newUser.setEmail(email);
            newUser.setPassword(encPassword);
            newUser.setRole(role);
            newUser.setCreatedDate(unixTime);
            userRepository.save(newUser);
            return SetResponse.setStatusMessageSuccess(newUser.getUserId());
        }

    }
}
