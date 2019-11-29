package ru.kabanov.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;

/**
 * Created by yasup on 27.11.2019.
 */
public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    DepositSteps depositSteps = new DepositSteps();

    @Когда("выбран сервис \"(.*)\"")
    public void whenSelectService(String serviceName) {
        mainSteps.stepSelectService(serviceName);
    }

    @Тогда("выбрана валюта \"(.*)\"")
    public void thenSelectedCurrency(String currencyName) {
        depositSteps.stepSelectCurrency(currencyName);
    }

    @Когда("^заполнение полей$")
    public void whenFillFields(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> depositSteps.fillFieldsStep(field, value));
    }

    @Когда("выбран срок \"(.*)\" месяцев")
    public void whenPeriodSelectBox(String value) {
        depositSteps.stepPeriodSelectBox(value);
    }

    @Тогда("выбран чекбокс \"(.*)\"")
    public void thenSelectCheckBox(String nameBox) {
        depositSteps.stepClickCheckBox(nameBox);
    }

    @Тогда("проверка расчетов по вкладу$")
    public void checkCalculations(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> depositSteps.checkFillField(String.valueOf(field), String.valueOf(value)));
    }
}
