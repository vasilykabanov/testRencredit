package ru.kabanov.steps;

import ru.kabanov.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 27.11.2019.
 */
public class MainSteps {

    MainPage mainPage = new MainPage();

    @Step("выбираем раздел {0}")
    public void stepSelectService(String serviceName) {
        mainPage.selectService(serviceName);
    }
}
