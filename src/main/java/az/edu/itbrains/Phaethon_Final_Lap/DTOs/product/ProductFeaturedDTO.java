package az.edu.itbrains.Phaethon_Final_Lap.DTOs.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFeaturedDTO {
    private Long id;
    private String name;
    private double price;
    private String imageUrl;
}
