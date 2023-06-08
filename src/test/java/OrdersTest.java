import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class OrdersTest extends BaseOrdersTest{

    //вывод списка всех заказов
    @Test
    @DisplayName("check get all orders")
    @Description("Вывод всех заказов")
    @TmsLink("TestIt-102")
    public void checkGetOrders() {
        orderClient.getOrders().log().all()
                .statusCode(200);
    }
}
