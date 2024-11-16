package net.serenitybdd.screenplay.pageobjects.we_buy_any_car;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LandingPage extends PageObject {

    public static final Target ENTER_YOUR_REG = Target.the("Enter your car registration field")
            .located(By.xpath("//input[@id='vehicleReg']"));

    public static final Target GET_MY_CAR_VALUATION_BUTTON = Target.the("Get my car valuation button")
            .located(By.cssSelector("#btn-go"));

    public static final Target MILEAGE_FIELD = Target.the("Mileage field")
            .located(By.id("Mileage"));;
}
