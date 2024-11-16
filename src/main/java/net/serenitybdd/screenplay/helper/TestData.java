package net.serenitybdd.screenplay.helper;

import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


public class TestData {

    private static Logger logger = LoggerFactory.getLogger(TestData.class);

    public <T> void setData(DataKeys key, T value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public <T> T getData(DataKeys key) {
        return Serenity.sessionVariableCalled(key);
    }

    private boolean keyExist(DataKeys key) {
        return Serenity.hasASessionVariableCalled(key);
    }

    private boolean keyNotExist(DataKeys key) {
        return !Serenity.hasASessionVariableCalled(key);
    }

    public boolean dataExist(DataKeys key) {
        return keyExist(key) && Objects.nonNull(getData(key));
    }

    public enum DataKeys {
        VARIANT_REG,
        MAKE,
        MODEL,
        YEAR;
    }


}
