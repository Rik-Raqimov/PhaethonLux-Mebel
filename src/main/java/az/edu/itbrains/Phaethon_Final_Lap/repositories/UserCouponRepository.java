package az.edu.itbrains.Phaethon_Final_Lap.repositories;

import az.edu.itbrains.Phaethon_Final_Lap.models.Coupon;
import az.edu.itbrains.Phaethon_Final_Lap.models.User;
import az.edu.itbrains.Phaethon_Final_Lap.models.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCouponRepository extends JpaRepository<UserCoupon, Long> {
    Optional<UserCoupon> findByUserEmailAndCouponCode(String email, String code);

    Optional<UserCoupon> findByUserAndCoupon(User user, Coupon coupon);
}
