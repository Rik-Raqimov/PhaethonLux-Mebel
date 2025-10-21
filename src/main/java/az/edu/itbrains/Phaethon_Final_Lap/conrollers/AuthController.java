package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.auth.RegisterDTO;
import az.edu.itbrains.Phaethon_Final_Lap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String register(){
        return "auth/register.html";
    }


    @PostMapping("/register")
    public String register(RegisterDTO registerDto){

        boolean result = userService.registerUser(registerDto);
        return "redirect:/login";
    }
}
