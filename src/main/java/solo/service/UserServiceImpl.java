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

   public static int Fibonacci(int number){
        int num1 = 0; int num2 = 1;
        System.out.print("Fibonacci Series: " + num1 + " " + num2);

        for(int count = 1; count < number; count++){
            int nextNumber = num1 +num2;
            System.out.print(" " + nextNumber);
            num1 = num2;
            num2 = nextNumber;
        }
        return num2;
   }
    public static void main(String[] args) {
        int number = 5;
        int scale = Fibonacci(number);
        System.out.println("Scale app to " + scale + " replicas.");
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
