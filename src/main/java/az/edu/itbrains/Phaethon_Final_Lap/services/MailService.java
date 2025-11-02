package az.edu.itbrains.Phaethon_Final_Lap.services;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.contactMessage.ContactMessageCreateDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.ContactMessage;

public interface MailService {
     void sendMail(ContactMessageCreateDTO contactMessageCreateDTO);
}
