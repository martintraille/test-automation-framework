package net.serenitybdd.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.pageobjects.we_buy_any_car.CarDetailsPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

public class TheCar {

        public static Question<String> variant_Reg() {
            return TheTarget.textOf(CarDetailsPage.VARIANT_REG);
        }


}
