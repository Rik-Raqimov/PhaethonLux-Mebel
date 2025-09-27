package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.category.CategoryDTO;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.CategoryRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> getAllCategories(String categoryName) {
        return categoryRepository.findAll().stream().map(category -> modelMapper.map(category, CategoryDTO.class)).toList();
    }

}
