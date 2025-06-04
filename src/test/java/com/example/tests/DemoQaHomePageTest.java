package com.example.tests;

import com.example.driver.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.example.pages.DemoQaHomePage;


public class DemoQaHomePageTest {

    private WebDriver driver;
    private DemoQaHomePage demoQaHomePage;

    @Before
    public void setUp() {

        driver = DriverManager.getDriver();
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

        DriverManager.quitDriver();
    }
}
