package az.edu.itbrains.Phaethon_Final_Lap.DTOs.contactMessage;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessageDTO {
    private Long id;
    @NotBlank(message = "Ad boş ola bilməz")
    private String name;
    @NotBlank(message = "Mövzu boş ola bilməz")
    private String subject;
    @NotBlank(message = "Email boş ola bilməz")
    @Email(message = "Email düzgün deyil")
    private String email;
    @NotBlank(message = "Mesaj boş ola bilməz")
    private String message;
}
