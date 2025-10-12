package az.edu.itbrains.Phaethon_Final_Lap.DTOs.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private Long id;
    private String title;
    private String seoUrl;
    private String description;
    private String imageUrl;
}
