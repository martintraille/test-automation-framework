package net.serenitybdd.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.helper.CarRegistrationExtractor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CarSearchSteps {


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before
    public void dataExtraction() throws IOException {
        List<String> registrations = CarRegistrationExtractor.extractRegistrations("src/test/resources/car_input.txt");
        System.out.println("*******The registrations are**********:  " + registrations);

    }


    @Given("an input file containing car registrations")
    public void an_input_file_containing_car_registrations() {

        // TODO: 15/11/2024  - Use the stored registrations to search on webuyanycar.com
    }
    @When("a valuation search by registration is done on webuyanycar.com")
    public void a_valuation_search_by_registration_is_done_on_webiuyanycar_com() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see a search result")
    public void the_user_should_see_a_search_result() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
