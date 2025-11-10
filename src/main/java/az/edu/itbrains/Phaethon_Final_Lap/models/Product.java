    package az.edu.itbrains.Phaethon_Final_Lap.models;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.ArrayList;
    import java.util.List;

    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "products")
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String name;
        @Column(length = 500)
        private String description;
        @Column(nullable = false)
        private double price;
        @Column(nullable = false)
        private String imageUrl;

        @ManyToOne(fetch = FetchType.LAZY)
        private CategoryForProduct categoryForProduct;

        @ManyToOne(fetch = FetchType.LAZY)
        private Coupon coupon;

        @ElementCollection
        @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
        @OrderBy("sortOrder ASC")
        private List<ProductImageData> images = new ArrayList<>();
    }
