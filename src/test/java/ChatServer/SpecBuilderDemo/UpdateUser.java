package ChatServer.SpecBuilderDemo;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test
    public void updateUserTest()
    {
        RequestSpecBuilder requestSpecBuilder
                = new RequestSpecBuilder();

        PreemptiveBasicAuthScheme auth
                = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestSpecification = requestSpecBuilder
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin/")
                .setAuth(auth)
                .setAccept("application/json")
                .setContentType("application/json").build();


        RequestSpecification request = given().log().all().spec(requestSpecification)
                .body("{\n" +
                        "  \"username\": \"sample-user-3\",\n" +
                        "  \"password\": \"sample123\",\n" +
                        "  \"email\": \"sample@example.org\",\n" +
                        "  \"name\": \"Sample\",\n" +
                        "  \"surname\": \"User\",\n" +
                        "  \"chat_nickname\": \"samplNickname\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}");

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        ResponseSpecification responseSpecification
                = responseSpecBuilder
                .expectStatusCode(200).build();

        Response hitRequest = request.when().put("/restapi/user/227");

        String resp = hitRequest.then().log().all()
                .spec(responseSpecification).extract().asString();

        System.out.println(resp);

    }
}
