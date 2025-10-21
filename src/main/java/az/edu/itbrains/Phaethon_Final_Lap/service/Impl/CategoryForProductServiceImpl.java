package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.categoryForProduct.CategoryForProductDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.CategoryForProduct;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.CategoryForProductRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.CategoryForProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryForProductServiceImpl implements CategoryForProductService {
        private final CategoryForProductRepository categoryForProductRepository;
        private final ModelMapper modelMapper;
    @Override
    public List<CategoryForProductDTO> getAllCategoryForProduct() {
        List<CategoryForProduct> categoryForProducts = categoryForProductRepository.findAll();
        List<CategoryForProductDTO> categoryForProductDTOS = categoryForProducts.stream().map(categoryForProduct -> modelMapper.map(categoryForProduct, CategoryForProductDTO.class)).toList();
        return categoryForProductDTOS;
    }
}
