package shoponline;

import shoponline.model.ERole;
import shoponline.model.Product;
import shoponline.model.Role;
import shoponline.repository.ProductRepository;
import shoponline.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }

        if (productRepository.count() == 0) {
            System.out.println("Se adaugă produsele de start (fără poze)...");

            List<Product> products = new ArrayList<>();

            // ===== Haine =====
            products.add(new Product("Tricou Bumbac Negru", 89.99, "Mărime: M, 100% Bumbac Organic", "Haine"));
            products.add(new Product("Blugi Skinny Dama", 149.50, "Mărime: 38, Material: Denim", "Haine"));
            products.add(new Product("Jachetă de Piele Eco", 320.00, "Mărime: L, Piele ecologică", "Haine"));
            products.add(new Product("Rochie de Vară Înflorată", 199.99, "Mărime: S, Vâscoză 100%", "Haine"));
            products.add(new Product("Adidași Alergare", 299.00, "Mărime: 43, Talpă: Spumă EVA", "Haine"));

            // ===== Ceaiuri și Cafea =====
            products.add(new Product("Ceai Verde Sencha", 45.00, "Gramaj: 100g, Origine: Japonia", "Ceaiuri"));
            products.add(new Product("Infuzie Fructe de Pădure", 38.50, "Gramaj: 150g, Ingrediente: Hibiscus, măr", "Ceaiuri"));
            products.add(new Product("Ceai Negru English Breakfast", 42.00, "Gramaj: 100g, Amestec Assam și Ceylon", "Ceaiuri"));
            products.add(new Product("Cafea Boabe Columbia", 65.00, "Gramaj: 250g, 100% Arabica", "Cafea"));
            products.add(new Product("Ceai de Mușețel", 25.00, "Gramaj: 50g, Flori de mușețel Bio", "Ceaiuri"));

            // ===== Electronice =====
            products.add(new Product("Căști Bluetooth TWS", 250.00, "Anulare zgomot, Autonomie 5 ore", "Electronice"));
            products.add(new Product("Mouse Wireless Ergonomic", 120.00, "2400 DPI, 6 butoane, 2.4GHz", "Electronice"));
            products.add(new Product("Tastatură Mecanică RGB", 350.00, "Switch-uri Blue, layout US", "Electronice"));
            products.add(new Product("Monitor LED Curbat 27\"", 899.99, "Full HD, 1ms, 144Hz", "Electronice"));
            products.add(new Product("Hard Disk Extern 2TB", 310.00, "USB 3.0, Portabil", "Electronice"));

            // ===== Cărți =====
            products.add(new Product("Carte „Dune”", 55.00, "Autor: Frank Herbert, Editura: Nemira", "Carti"));
            products.add(new Product("Carte „Atomic Habits”", 49.00, "Autor: James Clear, Editura: Publica", "Carti"));
            products.add(new Product("Carte „Sapiens”", 62.00, "Autor: Yuval Noah Harari, Editura: Polirom", "Carti"));

            // ===== Casă și Grădină =====
            products.add(new Product("Set 2 Becuri LED Smart", 99.00, "Wi-Fi, RGB, Compatibil Alexa", "Casa"));
            products.add(new Product("Scaun de Birou Ergonomic", 450.00, "Material: Plasă, Suport lombar", "Casa"));
            products.add(new Product("Blender de Mare Viteză", 280.00, "Putere: 1200W, Capacitate: 1.5L", "Casa"));

            productRepository.saveAll(products);

            System.out.println(products.size() + " produse au fost adăugate în baza de date.");
        }
    }
}