package com.tau.webpage;

import com.tau.config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TheInternetCheckboxTest extends BaseTest {

    @Test
    public void toggleCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input[type=checkbox]"));
        assertTrue(checkboxes.size() >= 2);

        WebElement first = checkboxes.get(0);
        WebElement second = checkboxes.get(1);

        first.click();
        assertTrue(first.isSelected(), "Pierwszy checkbox powinien być zaznaczony po kliknięciu.");

        second.click();
        assertFalse(second.isSelected(), "Drugi checkbox powinien być odznaczony po kliknięciu.");
    }
}
