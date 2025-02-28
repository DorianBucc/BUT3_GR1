package com.iut.banque.test.selenium;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
public class TestPresenceLogoAccueil {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPresenceLogoAccueil() {
        driver.get("http://localhost:8080/_00_ASBank2023_war_exploded/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        assertTrue(driver.findElement(By.cssSelector("img")).isDisplayed());
    }
}
