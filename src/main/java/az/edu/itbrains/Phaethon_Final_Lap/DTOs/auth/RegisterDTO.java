package az.edu.itbrains.Phaethon_Final_Lap.DTOs.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    @NotBlank(message = "Ad bos ola bilmez")
    private String name;

    @NotBlank(message = "Soyad bos ola bilmez")
    private String surname;

    @NotBlank(message = "Email bos ola bilmez")
    @Email(message = "Email duzgun formatda olmalidir")
    private String email;

    @NotBlank(message = "sifre bos ola bilmez")
    @Size(min = 6, message = "sifre en azi 6 simvol olmalidir")
    private String password;
    @NotBlank(message = "Təsdiq şifrəsi boş ola bilməz")
    @Size(min = 6, message = "Təsdiq şifrəsi ən azı 6 simvol olmalıdır")
    private String confirmPassword;
}
