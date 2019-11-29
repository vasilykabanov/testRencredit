package ru.kabanov.steps;

import ru.kabanov.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 27.11.2019.
 */
public class MainSteps {

    MainPage mainPage = new MainPage();

    @Step("выбираем раздел Вклады")
    public void stepClickDeposit() {
        mainPage.waitElementIsDisplayed(mainPage.openDepositButton);
        mainPage.openDepositButton.click();
    }

    @Step("выбираем раздел \"(.*)\"")
    public void stepSelectService(String serviceName) {
        mainPage.selectService(serviceName);
    }
}
