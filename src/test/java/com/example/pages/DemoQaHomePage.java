package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoQaHomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String url = "https://demoqa.com/";

    // Локаторы для 6 блоков; на demoqa.com - блоки имеют класс 'card mt-4 top-card'
    private final By cardsLocator = By.cssSelector(".card.mt-4.top-card");

    public DemoQaHomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {

        driver.get(url);
    }

    public String getTitle() {

        return driver.getTitle();
    }

    public List<WebElement> getCards() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardsLocator));
        return driver.findElements(cardsLocator);
    }

    public void clickCardByIndex(int index) {
        List<WebElement> cards = getCards();
        if (index < 0 || index >= cards.size()) {
            throw new IllegalArgumentException("Invalid card index: " + index);
        }
        WebElement card = cards.get(index);
        wait.until(ExpectedConditions.elementToBeClickable(card));
        card.click();
    }
}
