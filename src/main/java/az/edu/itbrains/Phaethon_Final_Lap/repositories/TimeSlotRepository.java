package az.edu.itbrains.Phaethon_Final_Lap.repositories;

import az.edu.itbrains.Phaethon_Final_Lap.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findBySlotDateBetweenOrderBySlotDateAscStartTimeAsc(LocalDate startOfWeek, LocalDate endOfWeek);
}
