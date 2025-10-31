package az.edu.itbrains.Phaethon_Final_Lap.services;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.room.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> findAll();
}
