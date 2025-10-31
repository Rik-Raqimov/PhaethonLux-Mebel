package az.edu.itbrains.Phaethon_Final_Lap.services;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.team.TeamDTO;

import java.util.List;

public interface TeamMemberService {
    List<TeamDTO> getAllTeamMembers();
}
