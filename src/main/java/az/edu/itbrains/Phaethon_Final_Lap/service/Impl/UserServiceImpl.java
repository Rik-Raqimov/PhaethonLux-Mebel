package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.auth.RegisterDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.User;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.UserRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public boolean registerUser(RegisterDTO registerDto) {
        try {
            User findUser = userRepository.findByEmailIgnoreCase(registerDto.getEmail());
            if (findUser != null) {
                return false;
            }
            User user = new User();
            user.setName(registerDto.getName());
            user.setSurname(registerDto.getSurname());
            user.setEmail(registerDto.getEmail());
            user.setPassword(registerDto.getPassword());
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
