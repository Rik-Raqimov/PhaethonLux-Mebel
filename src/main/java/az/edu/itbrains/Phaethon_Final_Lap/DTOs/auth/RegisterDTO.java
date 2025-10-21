package az.edu.itbrains.Phaethon_Final_Lap.DTOs.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String confirmPassword;
}
