package az.edu.itbrains.Phaethon_Final_Lap.service;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.product.ProductDetailDTO;

import java.util.List;

public interface ProductService {
    List<ProductDetailDTO> getFilteredProducts(Long categoryId);

    ProductDetailDTO getProductById(Long id);
}
