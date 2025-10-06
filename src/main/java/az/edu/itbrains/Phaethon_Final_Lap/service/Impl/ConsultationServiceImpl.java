package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.consultation.ConsultationDTO;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ConsultationRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ConsultationDTO> findById(Long id) {
        return consultationRepository.findBgetAllConsultationsByServiceIdyId(id)
                .stream()
                .map(consultation -> modelMapper.map(consultation, ConsultationDTO.class))
                .toList();
    }
}
