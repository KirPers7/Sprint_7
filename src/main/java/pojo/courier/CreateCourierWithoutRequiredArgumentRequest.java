package pojo.courier;

public class CreateCourierWithoutRequiredArgumentRequest {

    private String password;
    private String firstName;

    public CreateCourierWithoutRequiredArgumentRequest(String password, String firstName) {
        this.password = password;
        this.firstName = firstName;
    }

    public CreateCourierWithoutRequiredArgumentRequest() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
