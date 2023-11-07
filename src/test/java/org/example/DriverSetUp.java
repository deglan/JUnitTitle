package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Slf4j
public class DriverSetUp {

    WebDriver driver;
    PageTitleChecker pageTitleChecker = new PageTitleChecker(driver);

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void driverSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        log.info("Inicjalizacja WebDrivera - INFO");
        log.debug("Inicjalizacja WebDrivera - DEBUG");
        log.error("Inicjalizacja WebDrivera - ERROR");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
        log.info("Zamknięcie WebDrivera - INFO");
        log.debug("Zamknięcie WebDrivera - DEBUG");
        log.error("Zamknięcie WebDrivera - ERROR");
    }
}
