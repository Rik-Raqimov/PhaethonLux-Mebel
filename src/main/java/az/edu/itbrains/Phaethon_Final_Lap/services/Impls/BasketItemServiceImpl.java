package az.edu.itbrains.Phaethon_Final_Lap.services.Impls;

import az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket.BasketDTO;
import az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket.BasketItemDTO;
import az.edu.itbrains.Phaethon_Final_Lap.models.*;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.*;
import az.edu.itbrains.Phaethon_Final_Lap.services.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketItemServiceImpl implements BasketItemService {

    private final BasketItemRepository basketItemRepository;
    private final UserCouponRepository userCouponRepository;
    private final ProductRepository productRepository;
    private final CouponRepository couponRepository;
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
                .sorted(Comparator.comparing(basketItem -> basketItem.getProduct().getId()))
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
                .mapToDouble(BasketItem::getTotalPrice).sum();

        double shipping = subtotal > 0 ? 10.0 : 0; // Пример: 10 за доставку
        double total = subtotal + shipping;

        double couponDiscount = 0.0;
        UserCoupon userCoupon = basket.getUserCoupon();
        if (userCoupon != null && !userCoupon.isUsed()){
            Coupon coupon = userCoupon.getCoupon();
            if (coupon.isActive()
                    && coupon.getStartDateTime().isBefore(LocalDateTime.now())
                    && coupon.getEndDateTime().isAfter(LocalDateTime.now())){
                couponDiscount = subtotal * (coupon.getDiscount() / 100);
                total -= couponDiscount;
            }
        }


        double cashback = 0.0;
        Double basketCashback = user.getCashbackPercentage();
        if (total >= 500) {
            cashback = total * ((basketCashback != null ? basketCashback : 0.0) / 100.0);
        }

        // 5. Возвращаем BasketDTO с товарами и суммами
        return new BasketDTO(subtotal, shipping, total, cashback, couponDiscount,  basketItems);
    }

    @Override
    public void updateBasket(String email, Long productId, int quantity,String action) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı: " + email));

        BasketItem basketItem = basketRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Səbət tapılmadı"))
                .getBasketItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Əşya səbətdə tapılmadı"));
        if ("increase".equals(action)) {
            basketItem.setQuantity(basketItem.getQuantity() + 1);
        } else if ("decrease".equals(action)) {
            int newQty = basketItem.getQuantity() - 1;
            basketItem.setQuantity(Math.max(1, newQty));
        } else {
            basketItem.setQuantity(quantity); // на случай ручного ввода
        }

        basketItemRepository.save(basketItem);

    }

    @Override
    public void applyCoupon(String email, String code) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Sebet tapilmadi"));

        Basket basket = basketRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Sebet tapilmadi"));

        Coupon coupon = couponRepository.findByCode(code);
        if (coupon == null) throw new RuntimeException("Kupon tapilmadi");

        if (!coupon.isActive()){
            throw new  RuntimeException("Kupon aktiv deyil");
        }
        if (coupon.getEndDateTime().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Kuponun müddəti bitdi.");
        }

        UserCoupon userCoupon = userCouponRepository.findByUserAndCoupon(user, coupon)
                .orElseGet(() -> {
                    UserCoupon uc = new UserCoupon();
                    uc.setUser(user);
                    uc.setCoupon(coupon);
                    uc.setUsed(false);
                    return userCouponRepository.save(uc);
                });

        // 6. Проверяем, не использован ли купон
        if (userCoupon.isUsed()) throw new RuntimeException("Kupon artıq istifadə olunub");


        basket.setUserCoupon(userCoupon);
        basketRepository.save(basket);

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