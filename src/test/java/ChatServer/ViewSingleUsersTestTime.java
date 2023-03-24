package ChatServer;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class ViewSingleUsersTestTime {

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
                .time(lessThan(2L), TimeUnit.SECONDS);
                //.time(greaterThan(500L));
                //.time(both(greaterThanOrEqualTo(500L)).and(lessThanOrEqualTo(1500L)));


    }

}
