package task;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static util.enums.RestGraphService.*;

public class GetLastEmail implements Task {

    public static GetLastEmail getLastEmail(){
        return Tasks.instrumented(GetLastEmail.class);
    }

    public void IsFinished(){
        try{
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            RequestSpecification request = RestAssured.given()
                    .baseUri(BASE_URL.toString())
                    .header("Authorization", "Bearer " + TOKEN.toString())
                    .basePath(API_VERSION.toString() + MESSAGES_RESOURCE.toString())
                    .param("select", "Subject,receivedDateTime")
                    .param("Top", "1");
            Response response = request.get();
        System.out.println("Response body: " + response.getBody().prettyPrint());
        IsFinished();
    }

}
