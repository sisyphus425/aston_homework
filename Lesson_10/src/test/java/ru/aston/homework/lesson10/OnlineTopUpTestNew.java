package ru.aston.homework.lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineTopUpTestNew {

    private WebDriver driver;

    // Инициализация браузера перед каждым тестом
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
    }

    // Закрытие браузера после каждого теста
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // закрытие всплывающего окна с куками
    private void acceptCookiesIfPresent() {
        List<WebElement> buttons = driver.findElements(By.id("cookie-agree"));
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
        }
    }


    // Тест №1: проверка placeholder во всех вариантах оплаты
    @Test
    void checkPaymentPlaceholders() {
        OnlineTopUpPage page = new OnlineTopUpPage(driver);
        page.acceptCookiesIfPresent();

        // Ожидаемые значения placeholder
        String expectedPhone = "Номер телефона";
        String expectedSum   = "Сумма";
        String expectedEmail = "E-mail для отправки чека";

        // 1. Услуги связи
        page.selectPaymentType("Услуги связи");
        assertEquals(expectedPhone, page.getPhonePlaceholder(),
                "Неверный placeholder телефона для 'Услуги связи'");
        assertEquals(expectedSum, page.getSumPlaceholder(),
                "Неверный placeholder суммы для 'Услуги связи'");
        assertEquals(expectedEmail, page.getEmailPlaceholder(),
                "Неверный placeholder e-mail для 'Услуги связи'");

        // 2. Домашний интернет
        page.selectPaymentType("Домашний интернет");
        assertEquals(expectedPhone, page.getPhonePlaceholder(),
                "Неверный placeholder телефона для 'Домашний интернет'");
        assertEquals(expectedSum, page.getSumPlaceholder(),
                "Неверный placeholder суммы для 'Домашний интернет'");
        assertEquals(expectedEmail, page.getEmailPlaceholder(),
                "Неверный placeholder e-mail для 'Домашний интернет'");

        // 3. Рассрочка
        page.selectPaymentType("Рассрочка");
        assertEquals(expectedPhone, page.getPhonePlaceholder(),
                "Неверный placeholder телефона для 'Рассрочка'");
        assertEquals(expectedSum, page.getSumPlaceholder(),
                "Неверный placeholder суммы для 'Рассрочка'");
        assertEquals(expectedEmail, page.getEmailPlaceholder(),
                "Неверный placeholder e-mail для 'Рассрочка'");

        // 4. Задолженность
        page.selectPaymentType("Задолженность");
        assertEquals(expectedPhone, page.getPhonePlaceholder(),
                "Неверный placeholder телефона для 'Задолженность'");
        assertEquals(expectedSum, page.getSumPlaceholder(),
                "Неверный placeholder суммы для 'Задолженность'");
        assertEquals(expectedEmail, page.getEmailPlaceholder(),
                "Неверный placeholder e-mail для 'Задолженность'");
    }



    // Тест №2: Проверка формы для подтверждения платежа
    @Test
    void showPaymentDetails() {
        OnlineTopUpPage page = new OnlineTopUpPage(driver);
        page.acceptCookiesIfPresent();

        page.selectPaymentType("Услуги связи");

        String phone = "297777777";
        String sum   = "100";
        String email = "aston111@mail.ru";

        page.fillConnectionForm(phone, sum, email);
        page.clickContinue();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. iframe платёжного виджета
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe.payment-widget-iframe")
        ));

        // 2. Сумма в блоке
        WebElement amountSpan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='pay-description__cost']//span")
                )
        );
        String amountText = amountSpan.getText();
        assertTrue(amountText.contains("100.00 BYN"));

        // 3. Сумма на кнопке
        WebElement payButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@type='submit']//span[contains(text(),'Оплатить')]")
                )
        );
        String payButtonText = payButton.getText();;
        assertTrue(payButtonText.contains("Оплатить 100.00 BYN"));

        // 4. Номер телефона
        WebElement phoneTextSpan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='pay-description__text']//span")
                )
        );
        String phoneText = phoneTextSpan.getText();
        String expectedPhoneInModal = "375" + phone;
        assertTrue(phoneText.contains(expectedPhoneInModal));

        // 5. Надписи у полей карты
        // Номер карты
        WebElement cardNumberLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Номер карты']")
                )
        );
        assertTrue(cardNumberLabel.isDisplayed());

        // Срок действия
        WebElement expiryLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Срок действия']")
                )
        );
        assertTrue(expiryLabel.isDisplayed());

        // CVC
        WebElement cvcLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='CVC']")
                )
        );
        assertTrue(cvcLabel.isDisplayed());

        // Имя и фамилия на карте
        WebElement nameLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Имя и фамилия на карте']")
                )
        );
        assertTrue(nameLabel.isDisplayed());

        // 6. Иконки платёжных систем
        List<WebElement> cardLogos = wait.until(driver ->
                driver.findElements(
                        By.cssSelector("div.cards-brands img")
                )
        );
        assertTrue(cardLogos.size() >= 4, "Ожидалось минимум 4 иконки платёжных систем");

        driver.switchTo().defaultContent();
    }



}