package az.edu.itbrains.Phaethon_Final_Lap.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "calendly")
public class Calendly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
