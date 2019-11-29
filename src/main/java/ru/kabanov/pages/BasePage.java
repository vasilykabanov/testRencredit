package ru.kabanov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kabanov.steps.BaseSteps;

/**
 * Created by yasup on 27.11.2019.
 */
public class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void waitElementIsDisplayed(WebElement element) {
        BaseSteps.driverWait = new WebDriverWait(BaseSteps.getDriver(), 10);
        BaseSteps.driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element) {
        waitElementIsDisplayed(element);
        BaseSteps.driverWait.until(ExpectedConditions.elementToBeClickable(element));
//        new WebDriverWait(BaseSteps.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementToBeClickableReturned(WebElement element) {
        return BaseSteps.driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fieldInput(WebElement element, String value) {
        waitElementIsDisplayed(element);
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}
