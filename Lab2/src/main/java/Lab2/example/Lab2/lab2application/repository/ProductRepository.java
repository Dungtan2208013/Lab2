package Lab2.example.Lab2.lab2application.repository;

import Lab2.example.Lab2.lab2application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
