package net.serenitybdd.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.helper.CarRegistrationExtractor;
import net.serenitybdd.screenplay.tasks.SearchCarValuation;

import java.io.IOException;
import java.util.List;

public class CarSearchSteps {
    private List<String> registrations;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before
    public void dataExtraction() throws IOException {
        registrations = CarRegistrationExtractor.extractRegistrations("src/test/resources/car_input.txt");

    }


    @Given("an input file containing car registrations")
    public void an_input_file_containing_car_registrations() throws InterruptedException {
        System.out.println("*******The registrations are**********:  " + registrations);
    }

    @When("a valuation search by registration is done on webuyanycar.com")
    public void a_valuation_search_by_registration_is_done_on_webuyanycar_com() {
        Actor user = OnStage.theActorCalled("User");

        for (String registration : registrations) {
            user.attemptsTo(SearchCarValuation.withRegistration(registration));
        }
    }


    @Then("the user should see a search result")
    public void the_user_should_see_a_search_result() {
     /* TODO: 16/11/2024  - now I need to store the values online and compare them with values from the output file.
         Multiple ways to do this, store into variables as you get it, place the expected output values in the scenario
         and check that way */
    }


}
