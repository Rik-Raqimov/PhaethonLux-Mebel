package az.edu.itbrains.Phaethon_Final_Lap.DTOs.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDetailDTO {
    private Long id;
    private String title;
    private String description;
    private String iconUrl;
}
