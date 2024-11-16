package net.serenitybdd.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.helper.CarRegistrationExtractor;
import net.serenitybdd.screenplay.helper.FileWriterUtils;
import net.serenitybdd.screenplay.questions.CarDetailsTableQuestion;
import net.serenitybdd.screenplay.questions.TheCar;
import net.serenitybdd.screenplay.tasks.SearchCarValuation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

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


    @Given("a list of car registrations extracted from an input file")
    public void an_input_file_containing_car_registrations() throws InterruptedException {
        System.out.println("*******The registrations are**********:  " + registrations);

    }

    @When("a valuation search by registration is done on webuyanycar.com")
    public void a_valuation_search_by_registration_is_done_on_webuyanycar_com() throws InterruptedException {
        Actor user = OnStage.theActorCalled("User");

        for (String registration : registrations) {
            user.attemptsTo(SearchCarValuation.withRegistration(registration));
        }

    }

    @Then("the user should see a search result")
    public void the_user_should_see_a_search_result() {
        Actor user = OnStage.theActorInTheSpotlight();

       String variantReg =  user.asksFor(TheCar.variant_Reg());
        System.out.println("!!!!!!!!!!!Variant Reg is:   " + variantReg);
        // Extract the table data
        Map<String, String> tableData = user.asksFor(CarDetailsTableQuestion.extracted());

        // Print the extracted data
        System.out.println("Extracted Table Data:");
        tableData.forEach((key, value) -> System.out.println(key + ": " + value));


        // Define the file path
        String filePath = "target/car_details.csv";

        // Write specific data to the file
        FileWriterUtils.writeToFile(filePath, tableData, registrations);

        System.out.println("Data written to file: " + filePath);
    }


}
