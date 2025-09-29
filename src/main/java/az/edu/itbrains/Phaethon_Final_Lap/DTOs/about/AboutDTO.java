package az.edu.itbrains.Phaethon_Final_Lap.DTOs.about;

import az.edu.itbrains.Phaethon_Final_Lap.models.AboutPoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AboutDTO {
    private Long id;
    private String imageUrl;
    private String imageUrl2;
    private String title;
    private String description1;
    private List<AboutPoint> points;
}
