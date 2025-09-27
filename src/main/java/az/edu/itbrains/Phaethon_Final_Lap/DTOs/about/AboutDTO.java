package az.edu.itbrains.Phaethon_Final_Lap.DTOs.about;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AboutDTO {
    private Long id;
    private String imageUrl;
    private String imageUrl2;
    private String subtitle;
    private String title;
    private String description1;
    private String description2;
    private String point1;
    private String point2;
    private String point3;
    private String point4;
}
