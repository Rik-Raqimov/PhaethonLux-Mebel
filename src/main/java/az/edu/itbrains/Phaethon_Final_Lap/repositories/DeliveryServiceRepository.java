package az.edu.itbrains.Phaethon_Final_Lap.repositories;

import az.edu.itbrains.Phaethon_Final_Lap.models.DeliveryService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface DeliveryServiceRepository extends JpaRepository<DeliveryService, Long> {
    List<DeliveryService> findAllByService_Id(Long serviceId);
}
