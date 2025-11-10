package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.models.Basket;
import az.edu.itbrains.Phaethon_Final_Lap.models.User;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.BasketRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;


}
