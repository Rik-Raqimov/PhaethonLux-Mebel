package az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialsCreateDTO {
    @NotBlank(message = "Şərh mətni boş ola bilməz")
    private String commentText;
    @NotBlank(message = "Reytinq boş ola bilməz")
    private Integer rating;
}
