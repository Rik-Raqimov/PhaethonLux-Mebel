package az.edu.itbrains.Phaethon_Final_Lap.DTOs.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInfoDTO {
    private Long id;
    private String heading;
    private String subtitle;
    private String description1;
    private String description2;
    private String phoneNumber;
    private String phoneText;
}
