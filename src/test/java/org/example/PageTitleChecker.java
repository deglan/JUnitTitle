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
        Assertions.assertEquals(expectedTitle, actualTitle, Message.INCORRECT_TITLE.getMessage());
    }
}
