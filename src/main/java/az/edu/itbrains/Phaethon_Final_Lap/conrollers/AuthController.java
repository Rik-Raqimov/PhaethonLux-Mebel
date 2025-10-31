package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.auth.RegisterDTO;
import az.edu.itbrains.Phaethon_Final_Lap.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "auth/login.html";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("register") RegisterDTO registerDTO){
        return "auth/register";
    }


    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("register") RegisterDTO registerDTO, BindingResult bindingResult){
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
            bindingResult.rejectValue("confirmPassword", "error.registerDTO", "Parollar uyğun gəlmir");
        }
        if (bindingResult.hasErrors()){
            return "auth/register";
        }
        boolean result = userService.registerUser(registerDTO);
        return "redirect:/login";
    }
}
