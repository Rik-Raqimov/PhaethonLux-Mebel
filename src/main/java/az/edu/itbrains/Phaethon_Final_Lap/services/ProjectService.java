package az.edu.itbrains.Phaethon_Final_Lap.services;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.project.ProjectDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.project.ProjectFeaturedDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO findById(Long id);
    List<ProjectFeaturedDTO> findAllByRoomName(String roomName);

}
