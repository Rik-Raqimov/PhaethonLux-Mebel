package az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDTO {
    private double subtotal;
    private double shipping;
    private double total;
    private double cashback;
    private double couponDiscount;
    private List<BasketItemDTO> items;
}
