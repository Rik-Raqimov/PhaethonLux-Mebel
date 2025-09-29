package az.edu.itbrains.Phaethon_Final_Lap.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AdmonitionSection {
    private String subtitle;
    @Column(length = 6000)
    private String description;
    private String icon;
}
