package shoponline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shoponline.model.Product;
import shoponline.repository.ProductRepository;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600) // Permite conexiuni de la React
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Acesta este endpoint-ul de unde React va citi produsele
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}