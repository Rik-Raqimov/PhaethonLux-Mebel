package az.edu.itbrains.Phaethon_Final_Lap.services;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.supportCard.SupportCardDTO;

import java.util.List;

public interface SupportCardService {
    List<SupportCardDTO> findById(Long id);
}
