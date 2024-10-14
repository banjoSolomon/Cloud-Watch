package solo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestResponse {
    private String message;
    private String username;
    private Long id;
}
