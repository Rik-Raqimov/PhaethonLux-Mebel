package az.edu.itbrains.Phaethon_Final_Lap.DTOs.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Long id;
    private String fullName;
    private String photoUrl;
    private String profession;
    private String instagramLink;
    private String facebookLink;
    private String twitterLink;
}
