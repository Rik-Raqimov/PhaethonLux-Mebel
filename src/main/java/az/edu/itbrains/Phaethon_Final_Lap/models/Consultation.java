package az.edu.itbrains.Phaethon_Final_Lap.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String phoneNumber;

    @OneToMany(mappedBy = "consultation")
    private List<Booking> bookings;

    @ManyToOne
    private Service service;
}
