package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials.TestimonialsCreateDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials.TestimonialsDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.User;
import az.edu.itbrains.Phaethon_Final_Lap.services.TestimonialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestimonialsController {
    private final TestimonialService testimonialService;

    @GetMapping("/testimonials")
    public String testimonialsPage(Model model) {
        List<TestimonialsDTO> testimonials = testimonialService.getAllTestimonials();
        model.addAttribute("testimonials", testimonials);
        return "testimonials";
}

            @PostMapping("/testimonials")
            @PreAuthorize("isAuthenticated()")
            public String submitTestimonial(@Valid TestimonialsCreateDTO testimonialCreateDTO, Principal principal, RedirectAttributes redirectAttributes) {
            String email =  principal.getName();
            testimonialService.postTestimonial(testimonialCreateDTO, email);
                redirectAttributes.addFlashAttribute("success", "Rəyiniz uğurla göndərildi.");
                return "redirect:/testimonials";
            }
        }
