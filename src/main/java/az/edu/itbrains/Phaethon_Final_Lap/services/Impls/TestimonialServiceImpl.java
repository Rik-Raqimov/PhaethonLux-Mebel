    package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

    import az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials.TestimonialsCreateDTO;
    import az.edu.itbrains.Phaethon_Final_Lap.DTOs.testimonials.TestimonialsDTO;
    import az.edu.itbrains.Phaethon_Final_Lap.models.Testimonial;
    import az.edu.itbrains.Phaethon_Final_Lap.models.User;
    import az.edu.itbrains.Phaethon_Final_Lap.repositories.TestimonialRepository;
    import az.edu.itbrains.Phaethon_Final_Lap.repositories.UserRepository;
    import az.edu.itbrains.Phaethon_Final_Lap.services.TestimonialService;
    import lombok.RequiredArgsConstructor;
    import org.modelmapper.ModelMapper;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    @RequiredArgsConstructor

    public class TestimonialServiceImpl implements TestimonialService {
        private final TestimonialRepository testimonialRepository;
        private final UserRepository userRepository;
        private final ModelMapper modelMapper;

        @Override
        public List<TestimonialsDTO> getAllTestimonials() {
            return testimonialRepository.findAll().stream()
                    .map(testimonial -> { TestimonialsDTO dto = modelMapper.map(testimonial, TestimonialsDTO.class);
                    dto.setEmail(testimonial.getUser().getEmail());
                    return dto;
                    })
                    .toList();
        }

        @Override
        public TestimonialsCreateDTO postTestimonial(TestimonialsCreateDTO testimonialCreateDTO, String email) {
            try {
                Testimonial testimonial = modelMapper.map(testimonialCreateDTO , Testimonial.class);

                User user = userRepository.findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı"));

                testimonial.setUser(user);
                testimonialRepository.save(testimonial);
                return testimonialCreateDTO;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
