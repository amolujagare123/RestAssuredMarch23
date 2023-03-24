package ChatServer;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ViewSingleUsers {

    @Test
    public void viewALlUsers()
    {
        RestAssured.baseURI = "http://chat.cookingwithamol.in/index.php/site_admin/";

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .contentType("application/json")
                .accept("application/json")
                .when().get("/restapi/user/291")
                .then().log().all().statusCode(200)
                .body("result.email",equalTo("shanthi@gmail.com"))
                .body("error",equalTo(false))
                .body("result.id",equalTo(291));

    }

}
