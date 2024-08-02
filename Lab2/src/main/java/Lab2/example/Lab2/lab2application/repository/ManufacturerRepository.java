package Lab2.example.Lab2.lab2application.repository;

import Lab2.example.Lab2.lab2application.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
