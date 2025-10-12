package az.edu.itbrains.Phaethon_Final_Lap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "testimonials")
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleComment;
    private String descComment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}
