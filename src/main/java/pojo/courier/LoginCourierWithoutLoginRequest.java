package pojo.courier;

public class LoginCourierWithoutLoginRequest {

    private String password;

    public LoginCourierWithoutLoginRequest(String password) {
        this.password = password;
    }

    public LoginCourierWithoutLoginRequest() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static LoginCourierWithoutLoginRequest from(CreateCourierRequest createCourierRequest) {
        return new LoginCourierWithoutLoginRequest(createCourierRequest.getPassword());
    }
}
