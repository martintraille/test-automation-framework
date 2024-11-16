package net.serenitybdd.screenplay.pageobjects.we_buy_any_car;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CookieChoicePopUpPage extends PageObject {
    public static final Target ACCEPT_ALL_COOKIES_BUTTON = Target.the("Accept all cookies button")
            .located(By.id("onetrust-accept-btn-handler"));
}
