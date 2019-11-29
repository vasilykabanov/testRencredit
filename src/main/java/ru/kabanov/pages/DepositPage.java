package ru.kabanov.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by yasup on 27.11.2019.
 */
public class DepositPage extends BasePage {

    @FindBy(xpath = "//div[@class='calculator__currency-content']/label")
    public List<WebElement> currencies;

    @FindBy(name = "amount")
    public WebElement depositAmount;

    @FindBy(xpath = "//select[@id='period']")
    public WebElement periodSelectBox;

    @FindBy(name = "replenish")
    public WebElement monthlyReplenishment;

    @FindBy(xpath = "//span[text()]")
    List<WebElement> elementsSpan;

    @FindBy(xpath = "//span[@class='js-calc-rate']")
    public WebElement rate;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    public WebElement result;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    public WebElement replenish;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    public WebElement earned;

    public void select(List<WebElement> collections, String currencyName) {
        for (WebElement currency : collections) {
            if (currency.getText().equalsIgnoreCase(currencyName)) {
                waitElementIsDisplayed(currency);
                currency.click();
                return;
            }
        }
        Assert.fail("Не найдена валюта! " + currencyName);
    }

    public void selectСurrency(String currencyName) {
        select(currencies, currencyName);
    }

    public void periodSelectBox(String value) {
        Select select = new Select(periodSelectBox);
        select.selectByValue(value);
    }

    public void fillField(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Сумма вклада":
                fieldInput(depositAmount, fieldValue);
                break;
            case "Ежемесячное пополнение":
                fieldInput(monthlyReplenishment, fieldValue);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void clickElementsSpan(String nameBox) {
        for (WebElement element : elementsSpan) {
            if (element.getText().equalsIgnoreCase(nameBox)) {
                waitElementToBeClickable(element);
                element.click();
                return;
            }
        }
        Assert.fail("Не найден элемент - " + nameBox);
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Ставка":
                return waitElementToBeClickableReturned(rate).getText();
            case "К снятию":
                return waitElementToBeClickableReturned(result).getText();
            case "Начислено %":
                return waitElementToBeClickableReturned(earned).getText();
            case "Пополнение на":
                return waitElementToBeClickableReturned(replenish).getText();
        }
        throw new AssertionError("Поле "+ fieldName + "не объявлено на странице");

    }
}
