package JobPortal;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateJob {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
               // .contentType("application/json")
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "\t\"experience\": [\n" +
                        "\t\t\"2 years in manual testing\",\n" +
                        "\t\t\"1 year in automation Testing\"\n" +
                        "\t],\n" +
                        "\t\"jobDescription\": \"5-year experience with manual testing API testing selenium are required\",\n" +
                        "\t\"jobId\": 12,\n" +
                        "\t\"jobTitle\": \"Automation Test Enginner\",\n" +
                        "\t\"project\": [\n" +
                        "\t\t{\n" +
                        "\t\t\t\"projectName\": \"Stock Management\",\n" +
                        "\t\t\t\"technology\": [\n" +
                        "\t\t\t\t\"php\",\n" +
                        "\t\t\t\t\"mysql\",\n" +
                        "\t\t\t\t\"java\"\n" +
                        "\t\t\t]\n" +
                        "\t\t}\n" +
                        "\t]\n" +
                        "}")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);
    }
}
