package az.edu.itbrains.Phaethon_Final_Lap.repositories;

import az.edu.itbrains.Phaethon_Final_Lap.models.SupportCard;
import az.edu.itbrains.Phaethon_Final_Lap.service.SupportCardService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportCardRepository extends JpaRepository<SupportCard, Long> {
    List<SupportCard> findAllByService_Id(Long id);
}
