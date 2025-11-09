package com.tau.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
    protected WebDriver driver;

    protected String getBrowser() {
        String b = System.getProperty("browser");
        return (b == null || b.isBlank()) ? "chrome" : b.toLowerCase();
    }

    @BeforeEach
    public void setUp() {
        switch (getBrowser()) {
            case "firefox" -> {
                FirefoxOptions fopts = new FirefoxOptions();
                fopts.addArguments("--headless=new");
                driver = new FirefoxDriver(fopts);
            }
            case "chrome" -> {
                ChromeOptions opts = new ChromeOptions();
                opts.addArguments("--headless=new");
                opts.addArguments("--disable-gpu");
                opts.addArguments("--no-sandbox");
                driver = new ChromeDriver(opts);
            }
            default -> throw new IllegalArgumentException("Unknown browser: " + getBrowser());
        }
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
