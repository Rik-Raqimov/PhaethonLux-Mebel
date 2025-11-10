package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket.BasketDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket.BasketItemDTO;
import az.edu.itbrains.Phaethon_Final_Lap.services.BasketItemService;
import az.edu.itbrains.Phaethon_Final_Lap.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class BasketController {

    private final BasketItemService basketItemService;
    private final UserService userService;

    @GetMapping("/basket")
    public String basket(Model model, Principal principal) {
        String email = principal.getName();
        BasketDTO basketDTO = basketItemService.getBasket(email);
        model.addAttribute("basket", basketDTO);

        boolean active = true;
        if (basketDTO.getTotal() == 0){
            active = false;
        }
        model.addAttribute("active", active);
        return "/basket";
    }

    @PostMapping("/basket/update")
    public String updateBasket(@Valid BasketItemDTO basketItemDTO,
                               BindingResult bindingResult,
                               Model model,
                               Principal principal) {

        String email = principal.getName();

        if (bindingResult.hasErrors()){
            BasketDTO basketDTO = basketItemService.getBasket(email);
            model.addAttribute("basket", basketDTO);
            return "/basket";
        }

        basketItemService.updateBasket(email, basketItemDTO.getProductId(), basketItemDTO.getQuantity());
        return "redirect:/basket";
    }

    @PostMapping("/basket/add")
    public String addToBasket(@Valid @RequestParam Long productId, @RequestParam int quantity, Principal principal){
        String email = principal.getName();
        basketItemService.addToBasket(email,productId,quantity);
        return "redirect:/basket";
    }


        @PostMapping("/basket/remove/{productId}")
        public String deleteFromBasket(@PathVariable Long productId, Principal principal){
            String email = principal.getName();
            basketItemService.deleteFromBasket(productId, email);
            return "redirect:/basket";
        }


}
