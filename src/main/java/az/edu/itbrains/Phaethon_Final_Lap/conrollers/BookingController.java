package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.TimeSlot.TimeSlotDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.consultation.ConsultationDTO;
import az.edu.itbrains.Phaethon_Final_Lap.service.ConsultationService;
import az.edu.itbrains.Phaethon_Final_Lap.service.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookingController {
    private final ConsultationService consultationService;
    private final TimeSlotService timeSlotService;

    @GetMapping("/service/consultation/{id}")
    public String serviceConsultationPage(@PathVariable Long id, Model model) {
        List<ConsultationDTO> consultationDTOS = consultationService.findById(id);
        model.addAttribute("consultations", consultationDTOS);
        return "service/consultation.html";
    }

    @GetMapping("/service/booking")
    public String serviceBookingPage(Model model) {
        List<TimeSlotDTO> slots = timeSlotService.getSlotsForWeek(LocalDate.now());
        model.addAttribute("timeSlots", slots);
        return "service/booking.html";
    }
    @PostMapping("/service/book/{slotId}/{userId}/{consultationId}")
    public String bookService(@PathVariable Long slotId, @PathVariable Long userId, @PathVariable Long consultationId, Model model) {
        TimeSlotDTO bookedSlot = timeSlotService.bookSlot(slotId, userId, consultationId);
        return "redirect:/service/booking/confirm/" + bookedSlot.getId();
    }
    @GetMapping("/service/booking/confirm/{slotId}")
    public String bookingConfirmation(@PathVariable Long slotId, Model model) {
        model.addAttribute("slotId", slotId);
        return "service/bookingConfirmation.html";
    }
}
