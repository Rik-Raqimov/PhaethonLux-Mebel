package az.edu.itbrains.Phaethon_Final_Lap.DTOs.admonition;

import az.edu.itbrains.Phaethon_Final_Lap.models.AdmonitionSection;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmonitionDTO {
    private Long id;
    private String title;
    private List<AdmonitionSection> admonitionSections;
}
