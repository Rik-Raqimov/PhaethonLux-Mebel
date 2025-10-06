package az.edu.itbrains.Phaethon_Final_Lap.DTOs.TimeSlot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotDTO {
    private Long id;
    private LocalDate slotDate;
    private LocalTime startTime;
    private boolean isBooked;
}
