package ru.aston.homework.lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlineTopUpPage {

    private final WebDriver driver;

    // корневой контейнер блока «Онлайн пополнение без комиссии»
    private final By paySection = By.xpath("//section[@class='pay']");

    public OnlineTopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getPaySection() {
        return driver.findElement(paySection);
    }

    public void acceptCookiesIfPresent() {
        var buttons = driver.findElements(By.id("cookie-agree"));
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
        }
    }

    // Выбор варианта оплаты по тексту (устойчивый к анимации списка)
    public void selectPaymentType(String optionText) {
        WebElement section = getPaySection();

        WebElement header = section.findElement(
                By.cssSelector("div.select__wrapper button.select__header")
        );
        header.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // нужная опция кликабельна
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//section[@class='pay']" +
                                "//ul[contains(@class,'select__list')]" +
                                "//p[@class='select__option' and normalize-space(text())='" + optionText + "']")
                )
        );

        // клик через Actions, чтобы избежать перехвата клика
        new Actions(driver)
                .moveToElement(option)
                .pause(Duration.ofMillis(200))
                .click()
                .perform();

        // ждём, пока список закроется
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//section[@class='pay']//ul[contains(@class,'select__list')]")
        ));
    }

    // placeholder полей
    public String getPhonePlaceholder() {
        return getPaySection()
                .findElement(By.id("connection-phone"))
                .getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        return getPaySection()
                .findElement(By.id("connection-sum"))
                .getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return getPaySection()
                .findElement(By.id("connection-email"))
                .getAttribute("placeholder");
    }

    // Заполнение полей варианта «Услуги связи»
    public void fillConnectionForm(String phone, String sum, String email) {
        WebElement phoneInput = getPaySection().findElement(By.id("connection-phone"));
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement sumInput = getPaySection().findElement(By.id("connection-sum"));
        sumInput.clear();
        sumInput.sendKeys(sum);

        WebElement emailInput = getPaySection().findElement(By.id("connection-email"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // Клик по кнопке «Продолжить»
    public void clickContinue() {
        WebElement button = getPaySection().findElement(
                By.xpath(".//form[@id='pay-connection']//button[contains(text(),'Продолжить')]")
        );
        button.click();
    }
}


