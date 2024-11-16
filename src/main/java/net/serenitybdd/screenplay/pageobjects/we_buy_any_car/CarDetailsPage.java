package net.serenitybdd.screenplay.pageobjects.we_buy_any_car;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarDetailsPage extends PageObject {

    //TODO Needed to pull out the reg and add it to file
    public static final Target VARIANT_REG = Target.the("Car registration")
            .located(By.xpath("//div[contains(@class, 'details-vrm ng-star-inserted')]"));

    public static final Target CAR_DETAIL_ROWS = Target.the("Table rows")
            .located(By.xpath("//div[contains(@class, 'd-table-row details-vehicle-row')]"));



}
