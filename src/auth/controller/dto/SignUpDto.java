package auth.controller.dto;

public class SignUpDto {
    private String id;
    private String password;

    public SignUpDto(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
