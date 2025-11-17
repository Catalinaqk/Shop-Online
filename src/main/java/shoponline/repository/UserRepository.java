package shoponline.repository;

import shoponline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Găsește user după username
    Optional<User> findByUsername(String username);

    // Verificări pentru înregistrare
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    // === LINIA CARE ÎȚI LIPSEA ===
    // Găsește user după email (folosită la login dacă te loghezi cu mailul)
    Optional<User> findByEmail(String email);
}