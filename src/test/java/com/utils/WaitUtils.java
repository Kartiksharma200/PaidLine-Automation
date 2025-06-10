package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    // public static void waitForUrlToContain(WebDriver driver, String partialUrl) {
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //     wait.until(ExpectedConditions.urlContains(partialUrl));
    // }
    public static void waitForUrlToContain(WebDriver driver, String partialUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}