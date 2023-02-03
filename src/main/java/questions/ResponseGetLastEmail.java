package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


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
        return lastResponse().statusCode() == code;
    }
}
