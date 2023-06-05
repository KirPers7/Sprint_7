package clients;

import io.restassured.response.ValidatableResponse;
import pojo.courier.*;

import static io.restassured.RestAssured.given;

public class CourierClient extends BaseClient {
    public ValidatableResponse create(CreateCourierRequest createCourierRequest) {
        return given()
                .spec(getSpec())
                .body(createCourierRequest)
                .post("/api/v1/courier")
                .then();
    }

    public ValidatableResponse login(LoginCourierRequest loginCourierRequest) {
        return given()
                .spec(getSpec())
                .body(loginCourierRequest)
                .when()
                .post("/api/v1/courier/login")
                .then();
    }

    public ValidatableResponse delete(int id) {
        return given()
                .spec(getSpec())
                .pathParam("id", id)
                .when()
                .delete("/api/v1/courier/{id}")
                .then();
    }

    public ValidatableResponse loginFakeCourier() {
        LoginCourierRequest loginCourierRequest = new LoginCourierRequest("courier01", "1234");
        return given()
                .spec(getSpec())
                .body(loginCourierRequest)
                .when()
                .post("/api/v1/courier/login")
                .then();
    }

    public ValidatableResponse createWithoutRequiredArgument(CreateCourierWithoutRequiredArgumentRequest createCourierWithoutRequiredArgumentRequest) {
        return given()
                .spec(getSpec())
                .body(createCourierWithoutRequiredArgumentRequest)
                .post("/api/v1/courier")
                .then();
    }

    public ValidatableResponse loginWithoutPassword(LoginCourierWithoutPasswordRequest loginCourierWithoutPasswordRequest) {
        return given()
                .spec(getSpec())
                .body(loginCourierWithoutPasswordRequest)
                .post("/api/v1/courier/login")
                .then();
    }

    public ValidatableResponse loginWithoutLogin(LoginCourierWithoutLoginRequest loginCourierWithoutLoginRequest) {
        return given()
                .spec(getSpec())
                .body(loginCourierWithoutLoginRequest)
                .post("/api/v1/courier/login")
                .then();
    }
}
