package az.edu.itbrains.Phaethon_Final_Lap.services;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials.TestimonialsCreateDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials.TestimonialsDTO;

import java.util.List;

public interface TestimonialService {
    List<TestimonialsDTO> getAllTestimonials();

    TestimonialsCreateDTO postTestimonial(TestimonialsCreateDTO testimonialCreateDTO, String email);
}
