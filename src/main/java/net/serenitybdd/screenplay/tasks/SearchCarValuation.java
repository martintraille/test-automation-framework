package net.serenitybdd.screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.pageobjects.we_buy_any_car.LandingPage;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class SearchCarValuation implements Task {

    private final String registration;

    public SearchCarValuation (String registration) {
        this.registration = registration;
    }

    public static SearchCarValuation withRegistration(String registration) {
        return instrumented(SearchCarValuation.class, registration);
    }

    @Step("{0} searches for valuation using registration #registration")
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Open.url("https://www.webuyanycar.com"),
                    Accept.allCookies());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(Enter.theValue(registration).into(LandingPage.ENTER_YOUR_REG),
                Enter.theValue("40000").into(LandingPage.MILEAGE_FIELD),
                Click.on(LandingPage.GET_MY_CAR_VALUATION_BUTTON));
    }


}
