package clients;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pojo.courier.*;

import static io.restassured.RestAssured.given;

public class CourierClient extends BaseClient {

    public static final String COURIER_URI = BASE_URI + "/courier";
    @Step("Создание курьера")
    public ValidatableResponse create(CreateCourierRequest createCourierRequest) {
        return given()
                .spec(getSpec())
                .body(createCourierRequest)
                .post(COURIER_URI)
                .then();
    }

    @Step("Логин курьера")
    public ValidatableResponse login(LoginCourierRequest loginCourierRequest) {
        return given()
                .spec(getSpec())
                .body(loginCourierRequest)
                .when()
                .post(COURIER_URI + "/login")
                .then();
    }

    @Step("Удаление курьера")
    public ValidatableResponse delete(int id) {
        return given()
                .spec(getSpec())
                .pathParam("id", id)
                .when()
                .delete(COURIER_URI + "/{id}")
                .then();
    }

    @Step("Логин несуществующего курьера")
    public ValidatableResponse loginFakeCourier() {
        LoginCourierRequest loginCourierRequest = new LoginCourierRequest("courier01", "1234");
        return given()
                .spec(getSpec())
                .body(loginCourierRequest)
                .when()
                .post(COURIER_URI + "/login")
                .then();
    }

    @Step("Создание курьера без обязательного параметра")
    public ValidatableResponse createWithoutRequiredArgument(CreateCourierWithoutRequiredArgumentRequest createCourierWithoutRequiredArgumentRequest) {
        return given()
                .spec(getSpec())
                .body(createCourierWithoutRequiredArgumentRequest)
                .post(COURIER_URI)
                .then();
    }

    @Step("Логин курьера без пароля")
    public ValidatableResponse loginWithoutPassword(LoginCourierWithoutPasswordRequest loginCourierWithoutPasswordRequest) {
        return given()
                .spec(getSpec())
                .body(loginCourierWithoutPasswordRequest)
                .post(COURIER_URI + "/login")
                .then();
    }

    @Step("Логин курьера без логина")
    public ValidatableResponse loginWithoutLogin(LoginCourierWithoutLoginRequest loginCourierWithoutLoginRequest) {
        return given()
                .spec(getSpec())
                .body(loginCourierWithoutLoginRequest)
                .post(COURIER_URI + "/login")
                .then();
    }
}
