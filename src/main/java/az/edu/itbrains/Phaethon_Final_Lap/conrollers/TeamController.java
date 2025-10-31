package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.team.TeamDTO;
import az.edu.itbrains.Phaethon_Final_Lap.services.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamController {
    private final TeamMemberService teamMemberService;

    @GetMapping("/teams")
    public String teamsPage(Model model) {
        List<TeamDTO> teamMembers = teamMemberService.getAllTeamMembers();
        model.addAttribute("teamMembers", teamMembers);
        return "team";
    }

}
