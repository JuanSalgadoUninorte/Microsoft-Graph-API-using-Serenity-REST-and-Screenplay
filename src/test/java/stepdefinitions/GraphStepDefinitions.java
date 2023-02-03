package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.ResponseGetLastEmail;
import task.GetLastEmail;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static util.enums.RestGraphService.BASE_URL;

public class GraphStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("The access to the API")
    public void theAccessToTheAPI() {
        OnStage.theActorCalled("Juan").whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("The request to the API")
    public void theRequestToTheAPI() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetLastEmail.getLastEmail());
    }

    @Then("Get a response with an status code {int}")
    public void getAResponseWithAnStatusCode(Integer int1) {
        int1 = 200;
        OnStage.theActorInTheSpotlight().should(
                seeThat("Last response status code is 200",
                        ResponseGetLastEmail.getResponse(int1))
        );
    }

}
