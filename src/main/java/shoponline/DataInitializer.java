package shoponline;

import shoponline.model.ERole;
import shoponline.model.Product;
import shoponline.model.Role;
import shoponline.repository.ProductRepository;
import shoponline.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifică dacă rolurile există deja, pentru a nu le adăuga de fiecare dată
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }
        if (productRepository.count() == 0) {
            productRepository.save(new Product("Laptop de Gaming", 4500.0, "Un laptop foarte puternic."));
            productRepository.save(new Product("Mouse Optic", 150.0, "Mouse cu 6 butoane și lumini RGB."));
            productRepository.save(new Product("Tastatură Mecanică", 350.0, "Tastatură cu switch-uri red."));
        }
    }
}