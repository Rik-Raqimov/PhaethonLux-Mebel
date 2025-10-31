package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.room.RoomDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.Room;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.RoomRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<RoomDTO> findAll() {
        List<Room> rooms = repository.findAll();
        List<RoomDTO> roomDTOS = rooms.stream().map(
                room -> new RoomDTO(room.getId(), room.getIconUrl(), room.getRoomName(), room.getProject().size())).toList();
        return roomDTOS;


    }

}