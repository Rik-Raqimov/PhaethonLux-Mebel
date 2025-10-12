package az.edu.itbrains.Phaethon_Final_Lap.DTOs.project;

import az.edu.itbrains.Phaethon_Final_Lap.models.ImageData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private List<ImageData> images;
}
