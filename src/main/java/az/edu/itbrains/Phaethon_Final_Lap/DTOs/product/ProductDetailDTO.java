package az.edu.itbrains.Phaethon_Final_Lap.DTOs.product;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.categoryForProduct.CategoryForProductDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.ProductImageData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private CategoryForProductDTO categoryForProduct;
    private List<ProductImageData> images;
}
