package az.edu.itbrains.Phaethon_Final_Lap.service;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.service.DeliveryDetailDTO;

import java.util.List;

public interface DeliveryServiceService {
    List<DeliveryDetailDTO> findById(Long id);
}
