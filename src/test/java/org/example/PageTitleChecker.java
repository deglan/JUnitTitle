package org.example;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class PageTitleChecker {

    private WebDriver driver;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void checkPageTitle(String actualTitle, String expectedTitle) {
        String cleanedActualTitle = actualTitle.replaceAll(Message.REGEX_TITLE.getMessage(),
                Message.REPLACE_TITLE.getMessage()).toLowerCase();
        String cleanedExpectedTitle = expectedTitle.replaceAll(Message.REGEX_TITLE.getMessage(),
                Message.REPLACE_TITLE.getMessage()).toLowerCase();

        Assertions.assertEquals(cleanedExpectedTitle, cleanedActualTitle, Message.INCORRECT_TITLE.getMessage());
    }

    public void close() {
        driver.quit();
    }
}
