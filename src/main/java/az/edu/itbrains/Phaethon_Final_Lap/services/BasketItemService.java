package az.edu.itbrains.Phaethon_Final_Lap.services;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket.BasketDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket.BasketItemDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.User;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface BasketItemService {

    BasketDTO getBasket(String email);
    
    void addToBasket(String email, Long productId, int quantity);

    void deleteFromBasket(Long productId, String email);

    void updateBasket(String email, Long productId, int quantity);
}
