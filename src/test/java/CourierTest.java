import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import pojo.courier.*;


public class CourierTest extends BaseTest{

    //курьер может авторизоваться + успешный запрос возвращает id
    @Test
    @DisplayName("check login courier")
    @Description("Создаётся успешно курьер и можно залогиниться под ним")
    @TmsLink("TestIt-103")
    public void checkLoginCourier() {

        //логин курьера
        LoginCourierRequest loginCourierRequest = LoginCourierRequest.from(createCourierRequest);
        id = courierClient.login(loginCourierRequest)
                .statusCode(200)
                .extract().jsonPath().get("id");
    }

    //нельзя создать двух одинаковых курьеров + если создать пользователя с логином, который уже есть, возвращается ошибка
    @Test
    @DisplayName("check create double courier")
    @Description("Проверка валидации создания дубля курьера")
    @TmsLink("TestIt-104")
    public void checkCreateCourierDouble() {

        //логин курьера
        LoginCourierRequest loginCourierRequest = LoginCourierRequest.from(createCourierRequest);
        id = courierClient.login(loginCourierRequest)
                .extract().jsonPath().get("id");

        //создание с теми же кредами
        courierClient.create(createCourierRequest)
                .statusCode(409)
                .body("message", Matchers.equalTo("Этот логин уже используется. Попробуйте другой."));

    }

    //чтобы создать курьера, нужно передать в ручку все обязательные поля + если одного из полей нет, запрос возвращает ошибку
    @Test
    @DisplayName("check create courier without required parameter")
    @Description("Проверка валидации на отсутствие обязательного входного параметра при создании курьера")
    @TmsLink("TestIt-105")
    public void checkCreateCourierWithoutRequiredArgumentRequest() {

        courierClient.createWithoutRequiredArgument(createCourierWithoutRequiredArgumentRequest)
                .statusCode(400)
                .body("message", Matchers.equalTo("Недостаточно данных для создания учетной записи"));
    }

    //система вернёт ошибку, если неправильно указать логин или пароль + если какого-то поля нет, запрос возвращает ошибку
    @Test
    @DisplayName("check login courier without required parameter")
    @Description("Проверка валидации на отсутствие обязательного входного параметра при логине курьера")
    @TmsLink("TestIt-106")
    @Issue("BUG-206")
    public void checkLoginCourierWithoutRequiredArgumentRequest() {

        //логин курьера без пароля
        LoginCourierWithoutPasswordRequest loginCourierWithoutPasswordRequest = LoginCourierWithoutPasswordRequest.from(createCourierRequest);
        courierClient.loginWithoutPassword(loginCourierWithoutPasswordRequest).log().all()
                .statusCode(400)
                .body("message", Matchers.equalTo("Недостаточно данных для входа"));

        //логин курьера без логина
        LoginCourierWithoutLoginRequest loginCourierWithoutLoginRequest = LoginCourierWithoutLoginRequest.from(createCourierRequest);
        courierClient.loginWithoutLogin(loginCourierWithoutLoginRequest).log().all()
                .statusCode(400)
                .body("message", Matchers.equalTo("Недостаточно данных для входа"));
    }

    //система вернёт ошибку, если неправильно указать логин или пароль + если авторизоваться под несуществующим пользователем, запрос возвращает ошибку
    @Test
    @DisplayName("check fake courier")
    @Description("Проверка валидации логине несуществующего в БД курьера")
    @TmsLink("TestIt-107")
    public void checkLoginFakeCourier() {
        courierClient.loginFakeCourier()
                .statusCode(404)
                .body("message", Matchers.equalTo("Учетная запись не найдена"));
    }

}
