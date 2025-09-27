package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.about.AboutDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.About;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.AboutRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<AboutDTO> getAllAbout() {
        List<About> abouts = aboutRepository.findAll();
        List<AboutDTO> aboutDTOS = abouts.stream().map(about -> modelMapper.map(about, AboutDTO.class)).toList();
        return aboutDTOS;
    }
}
