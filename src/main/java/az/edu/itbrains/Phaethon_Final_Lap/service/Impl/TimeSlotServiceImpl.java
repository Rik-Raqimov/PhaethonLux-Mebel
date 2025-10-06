package az.edu.itbrains.Phaethon_Final_Lap.service.Impl;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.TimeSlot.TimeSlotDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.Booking;
import az.edu.itbrains.Phaethon_Final_Lap.models.Consultation;
import az.edu.itbrains.Phaethon_Final_Lap.models.TimeSlot;
import az.edu.itbrains.Phaethon_Final_Lap.models.Users;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.BookingRepository;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ConsultationRepository;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.TimeSlotRepository;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.UsersRepository;
import az.edu.itbrains.Phaethon_Final_Lap.service.TimeSlotService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService {
    private final ConsultationRepository consultationRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final BookingRepository bookingRepository;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional(readOnly = true) // Только чтение, без изменений в базе
    public List<TimeSlotDTO> getSlotsForWeek(LocalDate dateInWeek) {

        // 1. Вычисляем начало и конец недели (с Понедельника по Воскресенье)
        LocalDate startOfWeek = dateInWeek.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = dateInWeek.with(DayOfWeek.SUNDAY);

        // 2. Запрашиваем данные из базы, отсортированные по дате и времени
        List<TimeSlot> slots = timeSlotRepository.findBySlotDateBetweenOrderBySlotDateAscStartTimeAsc(
                startOfWeek,
                endOfWeek
        );

        // 3. Конвертируем сущности TimeSlot в DTO для отправки на фронтенд
        return slots.stream()
                .map(slot -> modelMapper.map(slot, TimeSlotDTO.class))
                .collect(Collectors.toList());
    }

    // --- 2. ЛОГИКА БРОНИРОВАНИЯ ---

    /**
     * Создает новое бронирование и помечает слот как занятый.
     * @param slotId ID слота, который пользователь хочет забронировать.
     * @param userId ID пользователя, который делает бронирование.
     * @param consultationId ID услуги (консультации).
     * @return DTO забронированного слота.
     */
    @Override
    @Transactional // Обязательно, чтобы создать бронь и изменить статус слота одновременно
    public TimeSlotDTO bookSlot(Long slotId, Long userId, Long consultationId) {

        // 1. Находим TimeSlot
        TimeSlot slot = timeSlotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Слот с ID " + slotId + " не найден."));

        // 2. Проверка статуса (Критический шаг!)
        if (slot.isBooked()) {
            throw new IllegalStateException("Слот уже забронирован.");
        }

        // 3. Находим Пользователя и Услугу (предполагаем, что они существуют)
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден."));

        // Если у вас нет Consultation, удалите эту строку и используйте NULL или заглушку.
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new RuntimeException("Consultation not found: " + consultationId));

        // В реальном коде вы должны найти ConsultationRepository и использовать:
        // consultationRepository.findById(consultationId).orElseThrow(...)

        // 4. Создаем запись о Бронировании (Booking)
        Booking newBooking = new Booking();
        newBooking.setConsultation(consultation);
        newBooking.setClient(user);
        newBooking.setSlot(slot);
        newBooking.setCreatedAt(LocalDateTime.now()); // добавить поле в Booking, если нужно
        bookingRepository.save(newBooking);
        bookingRepository.save(newBooking);

        // 5. Обновляем статус TimeSlot
        slot.setBooked(true);
        TimeSlot updatedSlot = timeSlotRepository.save(slot);

        // 6. Возвращаем обновленный DTO
        return modelMapper.map(updatedSlot, TimeSlotDTO.class);
    }
}
