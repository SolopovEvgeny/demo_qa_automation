/*package com.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager {

    // Статическая переменная driver, которая хранит единственный экземпляр WebDriver.
    // Делается статической, чтобы обеспечить один общий драйвер для всего приложения (Singleton-паттерн).
    private static WebDriver driver;

    // Метод для получения экземпляра WebDriver.
    // Метод статический, чтобы можно было вызывать без создания объекта класса.
    public static WebDriver getDriver() {

        // Проверка, инициализирован ли драйвер.
        // Если driver равен null, значит драйвер еще не запущен.
        if (driver == null) {

            // Создается объект ChromeOptions для настройки параметров запуска браузера.
            ChromeOptions options = new ChromeOptions();

            // Добавляются параметры запуска Chrome:
            // --start-maximized — браузер запускается в развернутом окне.
            options.addArguments("--start-maximized");

            // --disable-infobars — отключает информационные панели, например "Chrome is being controlled by automated test software".
            options.addArguments("--disable-infobars");

            // --disable-extensions — отключает расширения Chrome для более стабильной работы.
            options.addArguments("--disable-extensions");

            // WebDriverManager скачивает и настраивает подходящий драйвер Chrome автоматически.
            // Позволяет не заботиться о ручной загрузке и настройке бинарника драйвера.
            WebDriverManager.chromedriver().setup();

            //Создается экземпляр браузера Chrome с указанными опциями и назначается переменной driver.
            driver = new ChromeDriver(options);

        }

        //Заканчивается условие и возвращается объект driver.
        //Если драйвер уже был инициализирован ранее, возвращается существующий экземпляр.
        return driver;

    }

    // Метод для корректного завершения работы драйвера.
    public static void quitDriver() {

        // Проверяется, что драйвер инициализирован (не null).
        if (driver != null) {

            // Закрывается браузер и освобождаются ресурсы WebDriver.
            driver.quit();

            // Обнуляется переменная driver для возможности повторной инициализации позже.
            // Заканчивается метод и класс.
            driver = null;
        }
    }

}*/
