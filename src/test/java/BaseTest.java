import clients.CourierClient;
import dataprovider.CourierProvider;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import pojo.courier.CreateCourierRequest;
import pojo.courier.CreateCourierWithoutRequiredArgumentRequest;

public class BaseTest {

    protected final CourierClient courierClient = new CourierClient();
    protected Integer id;

    @Before
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
    CreateCourierRequest createCourierRequest = CourierProvider.getRandomCreateCourierRequest();
    CreateCourierWithoutRequiredArgumentRequest createCourierWithoutRequiredArgumentRequest =
            CourierProvider.getRandomCreateCourierWithoutRequiredArgumentRequest();

    @Before
    @DisplayName("check create courier")
    @Description("Создаётся успешно курьер")
    public void checkCreateCourier() {
        //создание курьера
        courierClient.create(createCourierRequest);
    }

    @After
    public void cleanUp() {
        if (id != null) {
            courierClient.delete(id).log().all()
                    .statusCode(200);
        }
    }
}
