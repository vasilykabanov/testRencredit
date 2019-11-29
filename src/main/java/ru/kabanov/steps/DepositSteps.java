package ru.kabanov.steps;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kabanov.pages.DepositPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 27.11.2019.
 */
public class DepositSteps {

    DepositPage depositPage = new DepositPage();

    @Step("выбрана валюта {0}")
    public void stepSelectCurrency(String currencyName) {
        depositPage.selectСurrency(currencyName);
    }

    @Step("поле {0} заполнено значением {1}")
    public void fillFieldsStep(String field, String value) {
        depositPage.fillField(field, value);
    }

    @Step("выбран срок {0}")
    public void stepPeriodSelectBox(String value) {
        depositPage.periodSelectBox(value);
    }

    @Step("выбран чекбокс - {0}")
    public void stepClickCheckBox(String nameBox) {
        if (!nameBox.equalsIgnoreCase("none")) {
            depositPage.clickElementsSpan(nameBox);
        }
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value) {
        new WebDriverWait(BaseSteps.getDriver(), 30)
                .withMessage(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, depositPage.getFillField(field), value))
                .until((ExpectedCondition<Boolean>) driver -> depositPage.getFillField(field).equals(value));
    }

}
