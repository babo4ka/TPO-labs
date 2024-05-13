package mainPackage.oksoft.lab5;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class OksoftTestLab5 {


    @Test
    public void testGet(){
        RestAssured
                .get("https://demo.oksoft.ru/JsonAndSettingsController/CartOrderedInfoGet")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
