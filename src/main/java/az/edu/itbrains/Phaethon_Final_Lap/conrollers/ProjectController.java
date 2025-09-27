package az.edu.itbrains.Phaethon_Final_Lap.conrollers;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.project.ProjectDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.project.ProjectFeaturedDTO;
import az.edu.itbrains.Phaethon_Final_Lap.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;


    @GetMapping("/portfolios/{roomName}")
    public String projectId(@PathVariable  String roomName, Model model) {
        List<ProjectFeaturedDTO> projectFeaturedDTOS = projectService.findAllByRoomName(roomName);
        model.addAttribute("projects", projectFeaturedDTOS);
        model.addAttribute("roomName", roomName);
        return "project/room-projects.html";

    }

    @GetMapping("/detail/{id}")
    public String projectDetail (@PathVariable Long id, Model model){
        ProjectDTO project  = projectService.findById(id);
        model.addAttribute("project",project);
        return "project/detail.html";

    }

}
