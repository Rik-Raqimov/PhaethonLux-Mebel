package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.repositories.TeamMemberRepository;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.TestimonialRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.TeamMemberService;
import az.edu.itbrains.Phaethon_Final_Lap.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {
    private final TestimonialRepository testimonialRepository;
    private final ModelMapper modelMapper;
}
