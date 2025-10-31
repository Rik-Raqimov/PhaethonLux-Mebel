package az.edu.itbrains.Phaethon_Final_Lap.security;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalSecurityExceptionHandler {
    @ExceptionHandler(AuthenticationException.class)
    public String handleAuthenticationException(AuthenticationException ex, RedirectAttributes redirectAttributes) {
       redirectAttributes.addFlashAttribute("error", "Rəy yazmaq üçün qeydiyyatdan keçiniz və ya daxil olun.");
       return "redirect:/register";
    }
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Sizin bu əməliyyatı yerinə yetirmək üçün icazəniz yoxdur.");
        return "redirect:/";
    }
}