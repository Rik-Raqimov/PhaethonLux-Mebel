package az.edu.itbrains.Phaethon_Final_Lap.DTOs.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectFeaturedDTO {
    private Long id;
    private String title;
    private String imageUrl;
    private double price;
}
