package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.consultation.ConsultationDTO;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ConsultationRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ConsultationDTO> getAllConsultationsByServiceId(Long id) {
        return consultationRepository.findAllByService_Id(id)
                .stream()
                .map(consultation -> modelMapper.map(consultation, ConsultationDTO.class))
                .toList();
    }

    @Override
    public ConsultationDTO findById(Long id) {
        return consultationRepository.findById(id)
                .map(consultation -> modelMapper.map(consultation, ConsultationDTO.class))
                .orElseThrow(() -> new RuntimeException("Məsləhətləşmə konsultanti tapılmadı: " + id));
    }
}
