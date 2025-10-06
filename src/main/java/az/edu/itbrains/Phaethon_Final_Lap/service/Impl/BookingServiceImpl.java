package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.repositories.BookingRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
}
