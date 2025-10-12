package az.edu.itbrains.Phaethon_Final_Lap.DTOs.supportCard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupportCardDTO {
    private Long id;
    private String title;
    private String description;
    private String iconUrl;
}
