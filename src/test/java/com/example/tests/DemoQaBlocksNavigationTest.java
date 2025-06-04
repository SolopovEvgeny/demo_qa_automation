package com.example.tests;

import com.example.driver.DriverManager;
import com.example.pages.DemoQaHomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaBlocksNavigationTest {

    private WebDriver driver;
    private DemoQaHomePage demoQaHomePage;
    private WebDriverWait wait;

    @Before
    public void setUp() {

        driver = DriverManager.getDriver();
        demoQaHomePage = new DemoQaHomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        demoQaHomePage.open();
    }

    @Test
    public void testAllSixCardsClickableAndNavigate() {

        int cardsCount = demoQaHomePage.getCards().size();
        Assert.assertEquals("Expected 6 cards on the homepage", 6, cardsCount);
        for (int i = 0; i < cardsCount; i++) {

            // Кликаем по карточке
            demoQaHomePage.clickCardByIndex(i);
            // Ждём изменение URL, чтобы убедиться что переход произошёл
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("https://demoqa.com/")));
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Card " + i + " navigated to URL: " + currentUrl);
            // Проверяем, что мы не на главной странице
            Assert.assertNotEquals("Navigation failed, still on main page", "https://demoqa.com/", currentUrl);
            // Возвращаемся назад на главную страницу
            driver.navigate().back();
            // Ждём пока вернёмся на главную (проверяем URL)
            wait.until(ExpectedConditions.urlToBe("https://demoqa.com/"));
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
