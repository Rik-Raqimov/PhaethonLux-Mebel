package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.contactMessage.ContactMessageCreateDTO;
import az.edu.itbrains.Phaethon_Final_Lap.services.ContactMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactMessageService contactMessageService;
    @GetMapping("/contact")
    public String contact( @ModelAttribute("contact") ContactMessageCreateDTO contactMessageCreateDTO) {
        return "/contact";
    }
    @PostMapping("/contact")
    public String sendContactMessage(@Valid @ModelAttribute("contact") ContactMessageCreateDTO contactMessageCreateDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            return "/contact";
        }
        contactMessageService.createContactMessage(contactMessageCreateDTO);
        return "redirect:/contact";
    }
}
