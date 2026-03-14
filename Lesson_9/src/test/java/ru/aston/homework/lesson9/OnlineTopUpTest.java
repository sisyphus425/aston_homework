package ru.aston.homework.lesson9;

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
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineTopUpTest {

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


    // Тест №1: проверка названия блока "Онлайн пополнение без комиссии"
    @Test
    void blockTitleShouldBeCorrect() {
        // закрытие баннера с куками
        acceptCookiesIfPresent();

        // Поиск заголовка блока оплаты по xpath
        WebElement title = driver.findElement(
                By.xpath("//section[@class='pay']//h2")
        );

        // замена \n на пробел, т.к. в разметке текст разделён тегом <br>.
        String actualText = title.getText().replace("\n", " ").trim();
        System.out.println("ACTUAL = [" + actualText + "]");

        // Проверка первой части заголовка
        assertTrue(actualText.contains("Онлайн пополнение"),
                "Текст заголовка не содержит ожидаемую фразу 'Онлайн пополнение'");
        // Проверка второй части заголовка
        assertTrue(actualText.contains("без комиссии"),
                "Текст заголовка не содержит ожидаемую фразу 'без комиссии'");
    }

    // Тест №2: проверка наличия всех логотипов платёжных систем
    @Test
    void paymentLogosShouldBeVisible() {
        // закрываем баннер с куками
        acceptCookiesIfPresent();

        // Поиск контейнера с логотипами
        WebElement partnersBlock = driver.findElement(
                By.xpath("//section[@class='pay']//div[@class='pay__partners']")
        );

        // Получение всех файлов изображения логотипов внутри контейнера и проверка, что их ровно 5
        List<WebElement> logos = partnersBlock.findElements(By.tagName("img"));
        assertTrue(logos.size() == 5, "Общее количество логотипов в блоке:" + logos.size());

        // Проверка, что каждый логотип реально виден на странице
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Один из логотипов не отображается");
            String alt = logo.getAttribute("alt");
            System.out.println("Logo alt = " + alt);
        }
    }

    // Тест №3: проверка работы ссылки «Подробнее о сервисе»
    @Test
    void moreAboutServiceLinkShouldWork() {
        // закрываем баннер с куками
        acceptCookiesIfPresent();

        WebElement link = driver.findElement(
                By.xpath("//a[normalize-space(text())='Подробнее о сервисе']")
        );

        // Проверка видимого текста ссылки
        String actualText = link.getText().trim();
        assertEquals("Подробнее о сервисе", actualText, "Неверный текст ссылки");

        // href содержит правильный путь к странице описания сервиса
        String href = link.getAttribute("href");
        assertTrue(href.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Неверный адрес ссылки: " + href);

        String oldUrl = driver.getCurrentUrl();
        link.click();

        // Проверка, что после клика URL страницы изменился - переход состоялся
        String newUrl = driver.getCurrentUrl();
        assertNotEquals(oldUrl, newUrl, "URL не изменился после клика по ссылке");
    }

    // Тест №4: заполнить форму и проверить работу кнопки «Продолжить»
    @Test
    void shouldAllowToClickContinueAfterFillingForm() {
        // закрываем баннер с куками
        acceptCookiesIfPresent();

        // Ввод номер телефона
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        // Ввод суммы
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.clear();
        sumInput.sendKeys("100");

        // Ввод e-mail
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.clear();
        emailInput.sendKeys("aston111@mail.ru");

        // Кнопка «Продолжить» должна стать активной
        WebElement continueButton = driver.findElement(
                By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]")
        );
        assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' должна быть активна после заполнения формы");

        // Клик по кнопке (если клик прошёл без исключения - кнопка работает)
        continueButton.click();
    }

}

