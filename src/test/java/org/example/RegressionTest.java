package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegressionTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @ParameterizedTest(name = "Test tytułu strony: {0}")
    @CsvFileSource(resources = "/test_data.csv", delimiter = ',')
    void testPageTitle(String url, String pageTitle) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);

        try {
            driver.get(url);
            PageTitleChecker pageTitleChecker = new PageTitleChecker(driver);
            String actualTitle = pageTitleChecker.getPageTitle();
            pageTitleChecker.close();
            pageTitleChecker.checkPageTitle(actualTitle, pageTitle);
        } finally {
            driver.quit();
        }
    }
}
