package az.edu.itbrains.Phaethon_Final_Lap.DTOs.beforeafter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeforeAfterDTO {
    private Long id;
    private String beforeImageUrl;
    private String afterImageUrl;
}
