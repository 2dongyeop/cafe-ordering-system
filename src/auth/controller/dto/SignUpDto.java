package auth.controller.dto;

public class SignUpDto extends AuthDto{
    private String id;
    private String password;

    public SignUpDto(String id, String password) {
        super(id, password);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
