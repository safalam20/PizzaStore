package pizza.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import pizza.User;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String firstname;
    private String lastName;
    private String streetName;
    private String cityName;
    private String postCode;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username,passwordEncoder.encode(password),firstname,lastName,streetName,
                cityName,postCode,phoneNumber);
    }
}
