package clients;

import io.restassured.response.ValidatableResponse;
import pojo.order.CreateOrderRequest;

import static io.restassured.RestAssured.given;

public class OrderClient extends BaseClient{

    public ValidatableResponse create(CreateOrderRequest createOrderRequest) {
        return given()
                .spec(getSpec())
                .body(createOrderRequest)
                .when()
                .post("/api/v1/orders")
                .then();
    }

    public ValidatableResponse getOrderByTrack(int track) {
        return given()
                .spec(getSpec())
                .pathParam("track", track)
                .when()
                .get("/api/v1/orders?t={track}")
                .then();
    }

    public ValidatableResponse getOrders() {
        return given()
                .spec(getSpec())
                .when()
                .get("/api/v1/orders")
                .then();
    }
}
