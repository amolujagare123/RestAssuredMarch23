package ChatServer;

import POJO.ChatServer.POJOCreateUser;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateUsersSerialization {

    @Test
    public void viewALlUsers()
    {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin/";

        POJOCreateUser ob = new POJOCreateUser();
        ob.setUsername("sample-user-1");
        ob.setPassword("abc123");
        ob.setName("Amol");
        ob.setSurname("Ujagare");
        ob.setChat_nickname("am123");
        ob.setEmail("amol@gmail.com");
        ArrayList<Integer> departments = new ArrayList<>(){{
            add(1);
            add(2);
        }};
        ob.setDepartments(departments);

        ArrayList<Integer> departments_read = new ArrayList<>(){
            {
                add(2);
            }};
        ob.setDepartments_read(departments_read);
        ArrayList<Integer> groups = new ArrayList<>(){
            {
                add(1);
            }};

        ob.setDepartment_groups(groups);
        ob.setUser_groups(groups);



        String response = given().log().all()
                .auth().preemptive().basic("admin", "admin123")
                .contentType("application/json")
                .accept("application/json")
                .body(ob)
                .when().post("/restapi/user")
                .then().statusCode(200).extract().asString();

        System.out.println(response);



    }

}
