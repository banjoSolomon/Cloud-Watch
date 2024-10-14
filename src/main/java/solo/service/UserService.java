package solo.service;

import solo.request.RegisterRequest;
import solo.response.RegisterRequestResponse;

public interface UserService {
    RegisterRequestResponse registerUser(RegisterRequest request);

}
