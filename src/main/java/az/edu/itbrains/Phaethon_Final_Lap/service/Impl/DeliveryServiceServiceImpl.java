package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.deliveryService.DeliveryDetailDTO;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.DeliveryServiceRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.DeliveryServiceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceServiceImpl implements DeliveryServiceService {
    private final DeliveryServiceRepository deliveryServiceRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DeliveryDetailDTO> findById(Long id) {
        return deliveryServiceRepository.findAllByService_Id(id)
                .stream()
                .map(deliveryService -> modelMapper.map(deliveryService, DeliveryDetailDTO.class))
                .toList();
    }
}