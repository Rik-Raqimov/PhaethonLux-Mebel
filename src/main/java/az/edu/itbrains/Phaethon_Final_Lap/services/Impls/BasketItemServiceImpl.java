package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket.BasketDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket.BasketItemDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.Basket;
import az.edu.itbrains.Phaethon_Final_Lap.models.BasketItem;
import az.edu.itbrains.Phaethon_Final_Lap.models.Product;
import az.edu.itbrains.Phaethon_Final_Lap.models.User;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.BasketItemRepository;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.BasketRepository;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.ProductRepository;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.UserRepository;
import az.edu.itbrains.Phaethon_Final_Lap.services.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketItemServiceImpl implements BasketItemService {

    private final BasketItemRepository basketItemRepository;
    private final ProductRepository productRepository;
    private final BasketRepository basketRepository;
    private final UserRepository userRepository;

    @Override
    public BasketDTO getBasket(String email) {
        // 1. Находим пользователя по email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("İstifadəçi e-poçtu ilə tapılmadı: " + email));

        // 2. Находим корзину пользователя или создаем новую
        Basket basket = basketRepository.findByUser(user)
                .orElseGet(() -> {
                    Basket newBasket = new Basket();
                    newBasket.setUser(user);
                    return basketRepository.save(newBasket);
                });

        // 3. Преобразуем товары в BasketItemDTO
        List<BasketItemDTO> basketItems = basket.getBasketItems().stream()
                .map(basketItem -> new BasketItemDTO(
                        basketItem.getProduct().getId(),
                        basketItem.getProduct().getName(),
                        basketItem.getProduct().getPrice(),
                        basketItem.getProduct().getImageUrl(),
                        basketItem.getQuantity()
                ))
                .toList();

        // 4. Вычисляем суммы
        double subtotal = basket.getBasketItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        double shipping = subtotal > 0 ? 10.0 : 0; // Пример: 10 за доставку
        double total = subtotal + shipping;

        // 5. Возвращаем BasketDTO с товарами и суммами
        return new BasketDTO(subtotal, shipping, total, basketItems);
    }

    @Override
    public void updateBasket(String email, Long productId, int quantity) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı: " + email));

        BasketItem basketItem = basketRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Səbət tapılmadı"))
                .getBasketItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Əşya səbətdə tapılmadı"));

        basketItem.setQuantity(quantity);

        basketItemRepository.save(basketItem);


    }

    @Override
    public void addToBasket(String email, Long productId, int quantity) {

        if (quantity < 1 || quantity > 100) {
            throw new IllegalArgumentException("Kəmiyyət 1-dən 100-ə qədər olmalıdır");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı: " + email));

        Basket basket = basketRepository.findByUser(user)
                .orElseGet(() -> {
                    Basket newBasket = new Basket();
                    newBasket.setUser(user);
                    return basketRepository.save(newBasket);
                });
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Məhsul tapılmadı: " + productId));

        BasketItem existingItem = basket.getBasketItems().stream().filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            basketItemRepository.save(existingItem);

        } else {
            BasketItem basketItem = new BasketItem();
            basketItem.setBasket(basket);
            basketItem.setProduct(product);
            basketItem.setQuantity(quantity);
            basketItemRepository.save(basketItem);
        }
    }

    @Override
    public void deleteFromBasket(Long productId, String email) {
    basketItemRepository.deleteByBasket_User_EmailAndProduct_Id(email, productId);
    }
}