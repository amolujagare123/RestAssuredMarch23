package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeckOfCardsDemo {

    @Test
    public void cardsTest()
    {
        RestAssured.baseURI = "https://deckofcardsapi.com";

        String respShuffle = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().statusCode(200).extract().asString();

        JsonPath jsonpath = new JsonPath(respShuffle);

        String deckID = jsonpath.get("deck_id");

        System.out.println(deckID);
        
        int drawCount = 2 ; // expectd result

        String respDraw = given().log().all().queryParam("count", drawCount)
                .when().get("/api/deck/" + deckID + "/draw/")
                .then().log().all().statusCode(200).extract().asString();

        JsonPath jsonpathRespDraw = new JsonPath(respDraw);

        int cardSize = jsonpathRespDraw.get("cards.size()");

        System.out.println(cardSize);

        Assert.assertEquals(drawCount,cardSize, "wrong count");

    }

}
