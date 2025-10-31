package az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialsDTO {
    private Long id;
    private String email;
    private String commentText;
    private Integer rating;
}
