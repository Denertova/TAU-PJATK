package com.tau.webpage;

import com.tau.config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SauceDemoTest extends BaseTest {

    @Test
    public void loginAndAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='inventory-list']")));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='shopping-cart-link']"))).click();

        WebElement cartList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='cart-list']")));

        assert cartList != null;
        assertFalse(
                cartList.findElements(By.cssSelector("[data-test='inventory-item']")).isEmpty(),
                "Koszyk powinien zawierać co najmniej jeden produkt po dodaniu"
        );
    }
}
