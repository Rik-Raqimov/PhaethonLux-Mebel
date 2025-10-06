package az.edu.itbrains.Phaethon_Final_Lap.service;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.consultation.ConsultationDTO;

import java.util.List;

public interface ConsultationService {
    List<ConsultationDTO> findById(Long id);

}
