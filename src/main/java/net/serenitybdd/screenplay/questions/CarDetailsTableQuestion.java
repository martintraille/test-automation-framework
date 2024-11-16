package net.serenitybdd.screenplay.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.pageobjects.we_buy_any_car.CarDetailsPage;
import net.serenitybdd.screenplay.pageobjects.we_buy_any_car.TablePage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDetailsTableQuestion implements Question<Map<String, String>> {

    public static CarDetailsTableQuestion extracted() {
        return new CarDetailsTableQuestion();
    }

    @Override
    public Map<String, String> answeredBy(Actor actor) {
        Map<String, String> tableData = new HashMap<>();

      //  List<WebElementFacade> rows = TablePage.TABLE_ROWS.resolveAllFor(actor);
        List<WebElementFacade> rows = CarDetailsPage.CAR_DETAIL_ROWS.resolveAllFor(actor);

        for (WebElementFacade row : rows) {

            //TODO - Relocate these locators to a Page Object instead
            String heading = row.find(By.xpath(".//div[contains(@class, 'd-table-cell heading')]")).getText();
            String value = row.find(By.xpath(".//div[contains(@class, 'd-table-cell value')]")).getText();


            System.out.println("Heading: " + heading + ", Value: " + value);

            tableData.put(heading.replace(":", ""), value);
        }

        return tableData;
    }
}