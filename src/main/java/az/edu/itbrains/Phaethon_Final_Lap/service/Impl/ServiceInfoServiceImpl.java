package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.service.ServiceDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.service.ServiceInfoDTO;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ServiceInfoRepository;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ServiceRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.ServiceInfoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class ServiceInfoServiceImpl implements ServiceInfoService {
    private final ServiceInfoRepository serviceInfoRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<ServiceInfoDTO> getAllServiceInfo() {
        return serviceInfoRepository.findAll()
                .stream()
                .map(serviceInfo -> modelMapper.map(serviceInfo, ServiceInfoDTO.class))
                .toList();
    }

}
