package az.edu.itbrains.Phaethon_Final_Lap.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "about")
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    private String imageUrl2;
    private String subtitle;
    private String title;
    @Column(length = 4000)
    private String description1;
    @Column(length = 4000)
    private String description2;
    private String point1;
    private String point2;
    private String point3;
    private String point4;
}
