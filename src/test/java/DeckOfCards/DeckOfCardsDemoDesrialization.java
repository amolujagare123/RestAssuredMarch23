package DeckOfCards;

import POJO.DeckOfCards.DrawCards.DrawCardsPOJO;
import POJO.DeckOfCards.ShuffleCardsPOJO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeckOfCardsDemoDesrialization {

    @Test
    public void cardsTest()
    {
        RestAssured.baseURI = "https://deckofcardsapi.com";

        ShuffleCardsPOJO respShuffleCardsObject = given().log().all()
                .queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all()
                .statusCode(200).extract().as(ShuffleCardsPOJO.class);

        String deckID = respShuffleCardsObject.getDeck_id();
        System.out.println("Success="+respShuffleCardsObject.isSuccess());
        System.out.println("Shuffled="+respShuffleCardsObject.isShuffled());
        System.out.println("Remaining="+respShuffleCardsObject.getRemaining());

        int drawCount = 2 ;

        DrawCardsPOJO respDrawCardsObject = given().log().all()
                .queryParam("count", drawCount)
                .when().get("/api/deck/" + deckID + "/draw/")
                .then().log().all()
                .statusCode(200).extract().as(DrawCardsPOJO.class);

        // print the drawn cards and remaining


        for (int i=0;i<respDrawCardsObject.getCards().size();i++) {
            System.out.println("Card Value="+respDrawCardsObject.getCards().get(i).getValue());
            System.out.println("Suit Value="+respDrawCardsObject.getCards().get(i).getSuit());
        }

        System.out.println("Remaining="+respDrawCardsObject.getRemaining());



    }

}
