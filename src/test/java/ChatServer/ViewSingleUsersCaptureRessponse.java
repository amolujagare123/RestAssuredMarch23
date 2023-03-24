package ChatServer;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ViewSingleUsersCaptureRessponse {

    @Test
    public void viewALlUsers()
    {
        RestAssured.baseURI = "http://chat.cookingwithamol.in/index.php/site_admin/";

        String response = given().log().all()
                .auth().preemptive().basic("admin", "admin123")
                .contentType("application/json")
                .accept("application/json")
                .when().get("/restapi/user/291")
                .then().statusCode(200).extract().asString();

        System.out.println(response);



    }

}
