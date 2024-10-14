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

    public void registerUserUsingFibonacci(int number , RegisterRequest request){
        int num = 0 , num2 = 1;
        for(int count = 0 ; count < number; count++){
            registerUser(request);
            int nextNumber = num + num2;
            num = num2;
            num2 = nextNumber;
            System.out.print("Register User with fibonacci : " + num2);
        }
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
