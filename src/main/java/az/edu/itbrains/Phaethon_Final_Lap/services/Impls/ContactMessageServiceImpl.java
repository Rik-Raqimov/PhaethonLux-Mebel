package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.contactMessage.ContactMessageCreateDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.ContactMessage;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ContactMessageRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {
    private final ContactMessageRepository contactMessageRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createContactMessage(ContactMessageCreateDTO contactMessageCreateDTO) {
            ContactMessage contactMessage = modelMapper.map(contactMessageCreateDTO, ContactMessage.class);
            contactMessageRepository.save(contactMessage);
    }
}
