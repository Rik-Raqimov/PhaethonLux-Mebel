package az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialsCreateDTO {
    @NotBlank(message = "Şərh mətni boş ola bilməz")
    private String commentText;

    @NotNull(message = "Qiymətləndirin")
    @Min(value = 1, message = "Qiymət ən azı 1 olmalıdır")
    @Max(value = 5, message = "Qiymət ən çox 5 ola bilər")
    private Integer rating;
}
