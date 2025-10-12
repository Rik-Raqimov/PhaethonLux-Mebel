package az.edu.itbrains.Phaethon_Final_Lap.DTOs.consultation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationUpdateDTO {
    private String name;
    private String imageUrl;
    private String role;
    private String phoneNumber;

}
