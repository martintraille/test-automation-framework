package net.serenitybdd.screenplay.tasks;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.helper.TestData;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.pageobjects.we_buy_any_car.LandingPage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.File;
import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class SearchCarValuation implements Task {

    private final String registration;
    @Steps(shared = true)
    private TestData testData;

    public SearchCarValuation(String registration) {
        this.registration = registration;
    }

    public static SearchCarValuation withRegistration(String registration)  {
        return instrumented(SearchCarValuation.class, registration);
    }

    @Step("{0} searches for valuation using registration #registration")
    public <T extends Actor> void performAs(T user) {

        try {
            user.attemptsTo(
                    Open.url("https://www.webuyanycar.com"),
                    Accept.allCookies());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        user.attemptsTo(WaitUntil.the(LandingPage.ENTER_YOUR_REG, WebElementStateMatchers.isVisible())
                .forNoMoreThan(5).seconds());
        user.attemptsTo(Enter.theValue(registration).into(LandingPage.ENTER_YOUR_REG),
                Enter.theValue("40000").into(LandingPage.MILEAGE_FIELD),
                Click.on(LandingPage.GET_MY_CAR_VALUATION_BUTTON));



    }
}
