package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.product.ProductDetailDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.Product;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ProductRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ProductDetailDTO> getFilteredProducts(Long categoryId) {
        if (categoryId == null) {
            return productRepository.findAll()
                    .stream()
                    .map(product -> modelMapper.map(product, ProductDetailDTO.class))
                    .toList();
        }

        return productRepository.findByCategoryForProduct_Id(categoryId)
                .stream()
                .map(p -> modelMapper.map(p, ProductDetailDTO.class))
                .toList();
    }

    @Override
    public ProductDetailDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return modelMapper.map(product, ProductDetailDTO.class);
        }
        return null;
    }
}
