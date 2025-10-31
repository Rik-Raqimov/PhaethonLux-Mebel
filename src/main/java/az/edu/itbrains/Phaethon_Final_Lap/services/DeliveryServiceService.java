package az.edu.itbrains.Phaethon_Final_Lap.services;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.deliveryService.DeliveryDetailDTO;

import java.util.List;

public interface DeliveryServiceService {
    List<DeliveryDetailDTO> findById(Long id);
}
