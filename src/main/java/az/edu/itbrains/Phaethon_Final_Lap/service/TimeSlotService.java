package az.edu.itbrains.Phaethon_Final_Lap.service;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.timeSlot.TimeSlotDTO;

import java.time.LocalDate;
import java.util.List;

public interface TimeSlotService {
    List<TimeSlotDTO> getSlotsForWeek(LocalDate dateInWeek);
    TimeSlotDTO bookSlot(Long slotId, Long userId, Long consultationId);
}
