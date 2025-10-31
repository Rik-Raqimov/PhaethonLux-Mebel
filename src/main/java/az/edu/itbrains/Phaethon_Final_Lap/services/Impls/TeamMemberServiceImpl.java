package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.team.TeamDTO;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.TeamMemberRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamMemberServiceImpl implements TeamMemberService {
    private final TeamMemberRepository teamMemberRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TeamDTO> getAllTeamMembers() {
        return teamMemberRepository.findAll().stream()
                .map(teamMember -> modelMapper.map(teamMember, TeamDTO.class))
                .toList();
    }
}
