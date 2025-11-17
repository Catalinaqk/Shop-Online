package shoponline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate template;

    // Putem apela acest endpoint cu Postman sau din browser pentru a testa
    // URL: http://localhost:8080/api/notifications/send?message=Salutare tuturor!
    @PostMapping("/send")
    public String sendNotification(@RequestParam String message) {
        // Trimite mesajul pe canalul "/topic/alerts"
        template.convertAndSend("/topic/alerts", message);
        return "Notificare trimisă: " + message;
    }
}