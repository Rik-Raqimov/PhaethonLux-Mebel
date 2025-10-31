package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.admonition.AdmonitionDTO;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.AdmonitionRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.AdmonitionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class AdmonitionServiceImpl implements AdmonitionService {
    private final AdmonitionRepository admonitionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AdmonitionDTO> getAllAdmonitions() {
        return admonitionRepository.findAll()
                .stream()
                .map(admonition -> modelMapper.map(admonition, AdmonitionDTO.class))
                .toList();
    }
}
