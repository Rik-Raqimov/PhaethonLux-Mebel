package az.edu.itbrains.Phaethon_Final_Lap.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ProductImageData {
    private String imageUrl;
    private Integer sortOrder;
}
