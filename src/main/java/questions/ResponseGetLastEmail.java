package questions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static util.enums.RestGraphService.*;
import static util.enums.RestGraphService.MESSAGES_RESOURCE;


public class ResponseGetLastEmail implements Question<Boolean> {

    private int code;

    public ResponseGetLastEmail(int code) {
        this.code = code;
    }

    public static ResponseGetLastEmail getResponse(int code) {
        return new ResponseGetLastEmail(code);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer "+TOKEN.toString());
        response = RestAssured.given()
                .header("Authorization", "Bearer "+TOKEN.toString())
                .get("https://graph.microsoft.com/beta/me/messages?select=Subject,receivedDateTime&Top=1");
        return response.statusCode() == code;
    }
}
