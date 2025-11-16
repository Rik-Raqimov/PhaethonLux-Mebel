package az.edu.itbrains.Phaethon_Final_Lap.DTOs.coupon;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponAddDTO {
    private String code;
}
