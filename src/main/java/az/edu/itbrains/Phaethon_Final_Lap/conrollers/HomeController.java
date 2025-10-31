package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.admonition.AdmonitionDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.beforeafter.BeforeAfterDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.category.CategoryDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.service.ServiceDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.serviceInfo.ServiceInfoDTO;
import az.edu.itbrains.Phaethon_Final_Lap.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final BeforeAfterService beforeAfterService;
    private final CategoryService categoryService;
    private final ServiceInfoService serviceInfoService;
    private final ServiceService serviceService;
    private final AdmonitionService admonitionService;



    @GetMapping("/")
    public String index(Model model) {
        List<BeforeAfterDTO> beforeAfterDTOList = beforeAfterService.getHomeBeforeAfterImage();
        List<ServiceInfoDTO> serviceInfoDTOList = serviceInfoService.getAllServiceInfo();
        List<ServiceDTO> serviceDTOList = serviceService.getAllServices();
        List<AdmonitionDTO> admonitionDTOList = admonitionService.getAllAdmonitions();
        model.addAttribute("admonitions", admonitionDTOList);
        model.addAttribute("services", serviceDTOList);
        model.addAttribute("serviceInfos", serviceInfoDTOList);
        model.addAttribute("beforeAfters", beforeAfterDTOList);
        return "index.html";

    }
    @GetMapping("/{categoryName}")
    public String index2( @PathVariable String categoryName,Model model){
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories(categoryName);
        model.addAttribute("categories", categoryDTOList);
        return "layout.html";
    }

}
