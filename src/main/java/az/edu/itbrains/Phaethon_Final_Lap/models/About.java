package az.edu.itbrains.Phaethon_Final_Lap.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String title;
    @Column(length = 8000)
    private String description1;

    @ElementCollection
    @CollectionTable(name = "about_points", joinColumns = @JoinColumn(name = "about_id"))
    @Column(name = "point")
    private List<AboutPoint> points;
}
