package az.edu.itbrains.Phaethon_Final_Lap.DTOs.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Long id;
    private String iconUrl;
    private String roomName;
    private int count;

}
