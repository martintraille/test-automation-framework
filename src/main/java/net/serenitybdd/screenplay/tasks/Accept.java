package net.serenitybdd.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.pageobjects.we_buy_any_car.CookieChoicePopUpPage;
import org.openqa.selenium.JavascriptExecutor;


public class Accept {

    private static boolean cookiesAccepted = false;
    public static Performable allCookies() throws InterruptedException {
        return Task.where("{0} accepts all cookies",
                actor -> {
                        if (!cookiesAccepted) {
                            try {
                                JavascriptExecutor jsExecutor = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
                                jsExecutor.executeScript("document.querySelector('.vwo-overlay').style.display='none';");
                                actor.attemptsTo(Click.on(CookieChoicePopUpPage.ACCEPT_ALL_COOKIES_BUTTON));
                                cookiesAccepted = true;
                            } catch (Exception e) {
                                throw new RuntimeException("Failed to accept cookies", e);
                        }
                    }
                }
        );

    }
}
