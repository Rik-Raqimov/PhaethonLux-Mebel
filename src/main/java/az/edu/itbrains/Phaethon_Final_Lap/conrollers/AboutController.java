package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.about.AboutDTO;
import az.edu.itbrains.Phaethon_Final_Lap.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;

    @GetMapping("/about")
    public String about(Model model){
        List<AboutDTO> aboutDTOS = aboutService.getAllAbout();
        model.addAttribute("about", aboutDTOS);
        return "about/about.html";
    }
}
