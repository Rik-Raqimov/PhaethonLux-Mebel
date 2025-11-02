package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.contactMessage.ContactMessageCreateDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.ContactMessage;
import az.edu.itbrains.Phaethon_Final_Lap.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(ContactMessageCreateDTO contactMessageCreateDTO){
        String toUser = contactMessageCreateDTO.getEmail();
        String subject = "Hörmətli " + contactMessageCreateDTO.getName();
        String body = """
            Sizin müraciətiniz uğurla qeydə alındı.
            Tezliklə əməkdaşlarımız sizinlə əlaqə saxlayacaqlar.

            Əlaqə üçün göstərdiyiniz email: %s

            Əlavə məlumat üçün bizimlə əlaqə saxlaya bilərsiniz.
            Əlaqə nömrəsi: +994 777
            """.formatted(contactMessageCreateDTO.getEmail());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toUser);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);


    }
}
