package ru.aston.homework.lesson11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;


@Epic("Онлайн пополнение МТС")
@Feature("Оплата без комиссии")
public class OnlineTopUpTestReview {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Story("Подтверждение оплаты услуг связи")
    @Description("Проверяем сумму, номер телефона, поля карты и иконки платёжных систем в модальном окне оплаты")
    @Severity(SeverityLevel.CRITICAL)
    void showPaymentDetails() {
        OnlineTopUpPage page = new OnlineTopUpPage(driver);

        openPageAndAcceptCookies(page);
        selectConnectionPayment(page);

        String phone = "297777777";
        String sum   = "100";
        String email = "aston111@mail.ru";

        fillFormAndOpenModal(page, phone, sum, email);
        checkModalDetails(phone);
    }

    @Step("Открываем страницу и принимаем cookies")
    void openPageAndAcceptCookies(OnlineTopUpPage page) {
        page.acceptCookiesIfPresent();
    }

    @Step("Выбираем вид оплаты: Услуги связи")
    void selectConnectionPayment(OnlineTopUpPage page) {
        page.selectPaymentType("Услуги связи");
    }

    @Step("Заполняем форму: телефон={phone}, сумма={sum}, email={email} и открываем модалку")
    void fillFormAndOpenModal(OnlineTopUpPage page, String phone, String sum, String email) {
        page.fillConnectionForm(phone, sum, email);
        page.clickContinue();
    }

    @Step("Проверяем сумму, телефон, поля карты и иконки в модальном окне")
    void checkModalDetails(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe.payment-widget-iframe")
        ));

        WebElement amountSpan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='pay-description__cost']//span")
                )
        );
        String amountText = amountSpan.getText();
        assertTrue(amountText.contains("100.00 BYN"));

        WebElement payButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@type='submit']//span[contains(text(),'Оплатить')]")
                )
        );
        String payButtonText = payButton.getText();
        assertTrue(payButtonText.contains("Оплатить 100.00 BYN"));

        WebElement phoneTextSpan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='pay-description__text']//span")
                )
        );
        String phoneText = phoneTextSpan.getText();
        String expectedPhoneInModal = "375" + phone;
        assertTrue(phoneText.contains(expectedPhoneInModal));

        WebElement cardNumberLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Номер карты']")
                )
        );
        assertTrue(cardNumberLabel.isDisplayed());

        WebElement expiryLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Срок действия']")
                )
        );
        assertTrue(expiryLabel.isDisplayed());

        WebElement cvcLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='CVC']")
                )
        );
        assertTrue(cvcLabel.isDisplayed());

        WebElement nameLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[text()='Имя и фамилия на карте']")
                )
        );
        assertTrue(nameLabel.isDisplayed());

        List<WebElement> cardLogos = wait.until(d ->
                d.findElements(By.cssSelector("div.cards-brands img"))
        );
        assertTrue(cardLogos.size() >= 4);

        driver.switchTo().defaultContent();
    }
}


