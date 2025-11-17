package shoponline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Aici activăm un broker simplu în memorie.
        // Orice mesaj care începe cu "/topic" va fi trimis către clienții abonați.
        config.enableSimpleBroker("/topic");

        // Prefixul pentru mesajele trimise de la client către server (dacă vom avea nevoie)
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Acesta este punctul de intrare ("priza") unde se conectează React
        registry.addEndpoint("/ws-shop")
                .setAllowedOriginPatterns("*") // Permite conectarea de oriunde (important pentru React)
                .withSockJS(); // Activează SockJS pentru fallback dacă browserul nu știe WS
    }
}