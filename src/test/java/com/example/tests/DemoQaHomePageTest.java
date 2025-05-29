package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.example.pages.DemoQaHomePage;

public class DemoQaHomePageTest {
    private WebDriver driver;
    private DemoQaHomePage demoQaHomePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        demoQaHomePage = new DemoQaHomePage(driver);
    }

    @Test
    public void testTitle() {
        demoQaHomePage.open();
        String title = demoQaHomePage.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals("DEMOQA", title);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
