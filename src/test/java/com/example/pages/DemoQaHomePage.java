package com.example.pages;

import org.openqa.selenium.WebDriver;

public class DemoQaHomePage {
    private WebDriver driver;
    private final String url = "https://demoqa.com/";

    public DemoQaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }
    // Тут можно добавить методы для взаимодействия с элементами страницы,
    // например, клик по кнопке, ввод данных, получение текста элементов и т.д.
}
