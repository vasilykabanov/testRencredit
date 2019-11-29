package ru.kabanov.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kabanov.steps.BaseSteps;

import java.util.List;

/**
 * Created by yasup on 27.11.2019.
 */
public class MainPage extends BasePage {

    @FindBy(xpath = "(//a[@href='/contributions/'])[2]")
    public WebElement openDepositButton;

    @FindBy(xpath = "//div[@class='service']")
    public List<WebElement> services;

    public void selectService(String serviceName) {
        for (WebElement item : services) {
            if (item.findElement(By.xpath(".//div[@class='service__title']")).getText().contains(serviceName)) {
                item.findElement(By.xpath(".//div[@class='service__title']/a")).click();
                return;
            }
        }
        Assert.fail("Не найден сервис! " + serviceName);
    }
}
