import clients.OrderClient;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pojo.order.CreateOrderRequest;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class OrderWithParametersTest extends BaseOrdersTest {

    private final OrderClient orderClient = new OrderClient();
    private final List<String> colors;

    public OrderWithParametersTest(List<String> colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters(name = "Цвет самоката. Тестовые данные: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {List.of("GREY")},
                {List.of("BLACK")},
                {Arrays.asList("GREY","BLACK")},
                {null}
        };
    }

    //создание заказа
    @Test
    @DisplayName("check create order and get order")
    @Description("Создание заказа")
    @TmsLink("TestIt-101")
    @Issue("BUG-201")
    public void checkCreateOrder() {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setFirstName("Ivan");
        createOrderRequest.setLastName("Grozny");
        createOrderRequest.setAddress("Moscow, pr. Kutuzova, 222");
        createOrderRequest.setMetroStation("Metrostroy");
        createOrderRequest.setPhone("89112223344");
        createOrderRequest.setRentTime(2);
        createOrderRequest.setDeliveryDate("2023-06-06");
        createOrderRequest.setComment("new device1");
        createOrderRequest.setColor(colors);

        //создание заказа
        Integer track = orderClient.create(createOrderRequest).log().all()
                .extract().jsonPath().get("track");

        //вызов заказа по номеру из БД
        orderClient.getOrderByTrack(track).log().all()
                .statusCode(200);
    }

}
