package net.serenitybdd.screenplay.pageobjects.we_buy_any_car;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TablePage {
    // Locate all rows in the table
    public static final Target TABLE_ROWS = Target.the("Table rows")
            .located(By.xpath("//div[contains(@class, 'd-table-row details-vehicle-row')]"));


}