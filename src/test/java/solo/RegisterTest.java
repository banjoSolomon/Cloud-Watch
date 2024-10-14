package solo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import solo.request.RegisterRequest;
import solo.response.RegisterRequestResponse;
import solo.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RegisterTest {
    @Autowired
    private UserService userService;
    @Test
    public void testUserCanRegister(){
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setPassword("password");
        RegisterRequestResponse response =  userService.registerUser(request);
        assertNotNull(response);
        assertEquals("Register successfully", response.getMessage());

    }
}
