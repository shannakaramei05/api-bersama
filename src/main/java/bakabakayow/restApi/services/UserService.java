package bakabakayow.restApi.services;

import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Users;
import bakabakayow.restApi.repository.UserRepository;
import bakabakayow.restApi.utils.SetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Response<List<Users>> getAllUser() {
        return SetResponse.setStatusMessageSuccess(userRepository.findAll());
    }
}
