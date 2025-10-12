package az.edu.itbrains.Phaethon_Final_Lap.service;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.consultation.ConsultationDTO;

import java.util.List;

public interface ConsultationService {
    List<ConsultationDTO> getAllConsultationsByServiceId(Long id);

    ConsultationDTO findById(Long id);
}
