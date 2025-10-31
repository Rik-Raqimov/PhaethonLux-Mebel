package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.room.RoomDTO;
import az.edu.itbrains.Phaethon_Final_Lap.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;


    @GetMapping("/portfolios")
    public String project(Model model) {
        List<RoomDTO> rooms = roomService.findAll();
        model.addAttribute("rooms", rooms);
        return "project/room.html";
    }
}
