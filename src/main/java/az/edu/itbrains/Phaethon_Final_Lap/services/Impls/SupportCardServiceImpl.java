package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.supportCard.SupportCardDTO;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.SupportCardRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.SupportCardService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportCardServiceImpl implements SupportCardService {

    private final SupportCardRepository supportCardRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<SupportCardDTO> findById(Long id) {
        return supportCardRepository.findAllByService_Id(id)
                .stream()
                .map(supportCard -> modelMapper.map(supportCard, SupportCardDTO.class))
                .toList();
    }
}
