package dataprovider;

import org.apache.commons.lang3.RandomStringUtils;
import pojo.courier.CreateCourierRequest;
import pojo.courier.CreateCourierWithoutRequiredArgumentRequest;

public class CourierProvider {
    public static CreateCourierRequest getRandomCreateCourierRequest() {

        CreateCourierRequest createCourierRequest = new CreateCourierRequest();
        createCourierRequest.setLogin(RandomStringUtils.randomAlphabetic(8));
        createCourierRequest.setPassword(RandomStringUtils.randomAlphabetic(8));
        createCourierRequest.setFirstName(RandomStringUtils.randomAlphabetic(8));

        return createCourierRequest;
    }

    public static CreateCourierWithoutRequiredArgumentRequest getRandomCreateCourierWithoutRequiredArgumentRequest() {
        CreateCourierWithoutRequiredArgumentRequest createCourierWithoutRequiredArgumentRequest =
                new CreateCourierWithoutRequiredArgumentRequest();
        createCourierWithoutRequiredArgumentRequest.setFirstName(RandomStringUtils.randomAlphabetic(8));
        createCourierWithoutRequiredArgumentRequest.setPassword(RandomStringUtils.randomAlphabetic(8));

        return createCourierWithoutRequiredArgumentRequest;

    }
}
