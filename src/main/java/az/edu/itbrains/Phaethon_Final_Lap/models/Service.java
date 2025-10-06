package az.edu.itbrains.Phaethon_Final_Lap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String imageUrl;


    @OneToMany(mappedBy = "service")
    private List<DeliveryService> deliveryServices = new ArrayList<>();

    @OneToMany(mappedBy = "service")
    private List<ServiceInfo> serviceInfos = new ArrayList<>();

    @OneToMany(mappedBy = "service")
    private List<Consultation> consultations = new ArrayList<>();
}
