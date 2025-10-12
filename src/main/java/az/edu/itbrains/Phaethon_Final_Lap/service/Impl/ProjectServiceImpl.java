package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.project.ProjectDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.project.ProjectFeaturedDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.Project;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ProjectRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;


    @Override
    public ProjectDTO findById(Long id) {
        Project projects = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Potrfolio tapilamdi!!" + id));

        return new ProjectDTO(
                projects.getId(),
                projects.getTitle(),
                projects.getDescription(),
                projects.getImageUrl(),
                projects.getImages()
        );
    }


    @Override
    public List<ProjectFeaturedDTO> findAllByRoomName(String roomName) {
        List<Project> projectList = projectRepository.findAllByRoom_RoomName(roomName);
        List<ProjectFeaturedDTO> projectFeaturedDTOS = projectList.stream().map(project -> modelMapper.map(
                project, ProjectFeaturedDTO.class
        )).toList();
        return projectFeaturedDTOS;
    }
}
