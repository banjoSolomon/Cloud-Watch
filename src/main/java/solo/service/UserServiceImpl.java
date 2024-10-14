package solo.service;

import org.springframework.stereotype.Service;
import solo.model.User;
import solo.repository.UserRepository;
import solo.request.RegisterRequest;
import solo.response.RegisterRequestResponse;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterRequestResponse registerUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        RegisterRequestResponse response = new RegisterRequestResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setMessage("Register successfully");
        return response;



    }
}
