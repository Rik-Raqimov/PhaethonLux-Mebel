package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.auth.RegisterDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.User;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.UserRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean registerUser(RegisterDTO registerDto) {
        try {
            User findUser = userRepository.findByEmail(registerDto.getEmail());
            if (findUser != null) {
                return false;
            }
            User user = new User();
            user.setName(registerDto.getName());
            user.setSurname(registerDto.getSurname());
            user.setEmail(registerDto.getEmail());
            String password = passwordEncoder.encode(registerDto.getPassword());
            user.setPassword(password);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
