package az.edu.itbrains.Phaethon_Final_Lap.repositories;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.consultation.ConsultationDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findAllByService_Id(Long serviceId);


}
