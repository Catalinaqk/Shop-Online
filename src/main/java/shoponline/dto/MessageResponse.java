package shoponline.dto;

// Un DTO simplu pentru a trimite mesaje (ex. "User registered successfully!")
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    // Getter și Setter
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}