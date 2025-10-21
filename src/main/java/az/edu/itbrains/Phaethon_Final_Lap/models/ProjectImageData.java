package az.edu.itbrains.Phaethon_Final_Lap.models;

import lombok.Data;

import jakarta.persistence.Embeddable;

@Data
@Embeddable
public class ProjectImageData {
    private String url;
    private String caption;
    private Integer sortOrder;
}
