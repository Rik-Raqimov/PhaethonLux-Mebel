    package az.edu.itbrains.Phaethon_Final_Lap.DTOs.basket;

    import jakarta.validation.constraints.Max;
    import jakarta.validation.constraints.Min;
    import jakarta.validation.constraints.NotBlank;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class BasketItemDTO {
        private Long productId;
        private String productName;
        private Double productPrice;
        private String productImageUrl;
        @Min(value = 1, message = "Kəmiyyət ən azı 1 olmalıdır")
        @Max(value = 100, message = "Kəmiyyət ən çoxu 100 ola bilər")
        private int quantity;

    }
