package pojo.courier;

public class LoginCourierWithoutPasswordRequest {

    private String login;

    public LoginCourierWithoutPasswordRequest(String login) {
        this.login = login;
    }

    public LoginCourierWithoutPasswordRequest() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static LoginCourierWithoutPasswordRequest from(CreateCourierRequest createCourierRequest) {
        return new LoginCourierWithoutPasswordRequest(createCourierRequest.getLogin());
    }
}
