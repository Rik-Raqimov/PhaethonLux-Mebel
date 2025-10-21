package az.edu.itbrains.Phaethon_Final_Lap.service;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.auth.RegisterDTO;

public interface UserService {
    boolean registerUser(RegisterDTO registerDto);
}
