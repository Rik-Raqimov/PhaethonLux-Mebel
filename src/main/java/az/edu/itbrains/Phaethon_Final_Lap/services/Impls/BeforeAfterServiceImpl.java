package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.beforeafter.BeforeAfterDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.BeforeAfter;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.BeforeAfterRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.BeforeAfterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeforeAfterServiceImpl implements BeforeAfterService {
    private final BeforeAfterRepository beforeAfterRepository;
    @Override
    public List<BeforeAfterDTO> getHomeBeforeAfterImage() {
        List<BeforeAfter> beforeAfters = beforeAfterRepository.findAll();
        List<BeforeAfterDTO> beforeAfterDTOList =beforeAfters
                .stream()
                .map(beforeAfter -> new BeforeAfterDTO(beforeAfter.getId() ,beforeAfter.getBeforeImageUrl(), beforeAfter.getAfterImageUrl())).toList();

        return beforeAfterDTOList;
    }
}
