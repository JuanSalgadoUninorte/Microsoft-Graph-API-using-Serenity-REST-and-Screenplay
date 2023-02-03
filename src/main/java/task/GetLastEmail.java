package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
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
        actor.attemptsTo(
                Get.resource(BASE_URL.toString()).with(
                        request -> request
                                .header("Authorization", "Bearer " + TOKEN.toString())
                                .param("select", "")
                                .param("Top", "1")
                )
        );
        System.out.println(lastResponse().getBody().prettyPrint());
    }

}
