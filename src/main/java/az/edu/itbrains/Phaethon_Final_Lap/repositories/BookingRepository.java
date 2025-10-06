package az.edu.itbrains.Phaethon_Final_Lap.repositories;

import az.edu.itbrains.Phaethon_Final_Lap.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
