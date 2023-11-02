package org.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class RegressionTest extends DriverSetUp {

    @Tag("regresja")
    @ParameterizedTest(name = "Test tytułu strony: {1}")
    @CsvFileSource(resources = "/test_data.csv", delimiter = ',', numLinesToSkip = 1)
    void testPageTitle(String url, String pageTitle) {
        driver.get(url);
        pageTitleChecker.checkPageTitle(driver.getTitle(), pageTitle);
    }
}
