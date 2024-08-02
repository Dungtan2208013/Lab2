package Lab2.example.Lab2.lab2application.service;

import Lab2.example.Lab2.lab2application.entity.Manufacturer;
import Lab2.example.Lab2.lab2application.repository.ManufacturerRepository;
import Lab2.example.Lab2.lab2application.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer updateManufacturer(Long id, Manufacturer manufacturerDetails) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found for this id :: " + id));

        manufacturer.setName(manufacturerDetails.getName());
        manufacturer.setOrigin(manufacturerDetails.getOrigin());
        manufacturer.setDescription(manufacturerDetails.getDescription());

        return manufacturerRepository.save(manufacturer);
    }

    @Transactional
    public void deleteManufacturer(Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found for this id :: " + id));

        if (manufacturer.getProducts().isEmpty()) {
            manufacturerRepository.delete(manufacturer);
        } else {
            throw new IllegalStateException("Cannot delete manufacturer with products");
        }
    }
}
