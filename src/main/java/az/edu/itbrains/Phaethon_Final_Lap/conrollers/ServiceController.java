package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.service.ServiceDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.service.DeliveryDetailDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.service.ServiceInfoDTO;
import az.edu.itbrains.Phaethon_Final_Lap.service.DeliveryServiceService;
import az.edu.itbrains.Phaethon_Final_Lap.service.ServiceInfoService;
import az.edu.itbrains.Phaethon_Final_Lap.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    private final DeliveryServiceService deliveryServiceService;
    private final ServiceService serviceService;
    private final ServiceInfoService serviceInfoService;

    @GetMapping("/services")
    public String serviceInfoPage(Model model) {
        List<ServiceInfoDTO> serviceInfoDTOList = serviceInfoService.getAllServiceInfo();
        List<ServiceDTO> serviceDTOList = serviceService.getAllServices();
        model.addAttribute("services", serviceDTOList);
        model.addAttribute("serviceInfos", serviceInfoDTOList);
        return "service/service.html";
    }
    @GetMapping("/service/detail/{id}")
    public String serviceDetailPage(@PathVariable Long id, Model model) {
        List<DeliveryDetailDTO> deliveryDetailDTOS = deliveryServiceService.findById(id);
        model.addAttribute("serviceDetails", deliveryDetailDTOS);
        return "service/deliveryDetail.html";
    }
}
