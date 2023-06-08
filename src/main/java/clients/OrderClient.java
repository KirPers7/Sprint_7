package clients;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pojo.order.CreateOrderRequest;

import static io.restassured.RestAssured.given;

public class OrderClient extends BaseClient{

    public static final String ORDERS_URI = BASE_URI + "/orders";

    @Step("Создание заказа")
    public ValidatableResponse create(CreateOrderRequest createOrderRequest) {
        return given()
                .spec(getSpec())
                .body(createOrderRequest)
                .when()
                .post(ORDERS_URI)
                .then();
    }

    @Step("Получение заказа по его номеру")
    public ValidatableResponse getOrderByTrack(int track) {
        return given()
                .spec(getSpec())
                .pathParam("track", track)
                .when()
                .get(ORDERS_URI + "?t={track}")
                .then();
    }

    @Step("Получение всех заказов")
    public ValidatableResponse getOrders() {
        return given()
                .spec(getSpec())
                .when()
                .get(ORDERS_URI)
                .then();
    }
}
