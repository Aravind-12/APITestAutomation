package stepDefination;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.ResponseMessageValidation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Utils;

public class RCBPlayerValidation extends Utils {

    RequestSpecification request;
    ResponseSpecification respSpec;
    Response response;


    @Given("I am RCB team management")
    public void iAmRcbTeamManagement() {
      //

    }

    @When("I submit the team for upcoming match")
    public void iSubmitTheTeamForUpcomingMatch(){

    }

    @Then("I verify team should have only four foreign player")
    public void iVerifyTeamShouldHaveOnlyFourForeignPlayer() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        ObjectMapper objectmaper = getObjectMapper();
        JsonNode response=obj.readTree(String.valueOf(objectmaper));
       assertEquals(response.get("country").textValue(),ResponseMessageValidation.COUNTRY_NAME1);
        assertEquals(response.get("country").textValue(),ResponseMessageValidation.COUNTRY);
        assertEquals(response.get("country").textValue(),ResponseMessageValidation.COUNTRY_NAME2);
    }

    @Then("I am notified team has at least one wicket keeper")
    public void iAmNotifiedTeamHasAtLeastOneWicketKeeper() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        ObjectMapper objectmaper = getObjectMapper();
        JsonNode response=obj.readTree(String.valueOf(objectmaper));
        assertEquals("Wicket-keeper",response.get("role").textValue());
    }

    @Then("I am notified team has more than four foreign player")
    public void iAmNotifiedTeamHasMoreThanFourForeignPlayer() {
    }

    @Then("I am notified team has more than one wicket keeper")
    public void iAmNotifiedTeamHasMoreThanOneWicketKeeper() {
    }
}
