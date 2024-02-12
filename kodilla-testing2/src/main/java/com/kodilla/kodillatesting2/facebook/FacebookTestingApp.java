package com.kodilla.kodillatesting2.facebook;

import com.kodilla.kodillatesting2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    // "button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy"
    public static final String XPATH_COOKIES = "//button[@class='_42ft _4jy0 _al66 _4jy3 _4jy1 selected _51sy']";

    // <a role="button" class="_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy" href="#"
    // ajaxify="/reg/spotlight/" id="u_0_0_B4" data-testid="open-registration-form-button" rel="async">
    public static final String XPATH_CREATE_ACCOUNT = "//a[@data-testid='open-registration-form-button']";

    // <select aria-label="Dzień" name="birthday_day" id="day" title="Dzień" class="_9407 _5dba _9hk6 _8esg">
    public static final String XPATH_SELECT_DAY = "//select[@id='day']";

    // <select aria-label="Miesiąc" name="birthday_month" id="month" title="Miesiąc" class="_9407 _5dba _9hk6 _8esg">
    public static final String XPATH_SELECT_MONTH = "//select[@id='month']";

    // <select aria-label="Rok" name="birthday_year" id="year" title="Rok" class="_9407 _5dba _9hk6 _8esg">
    public static final String XPATH_SELECT_YEAR = "//select[@id='year']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        acceptCookies(driver);

        createAnAccount(driver);

        selectDateOfBirth(driver);
    }

    private static void acceptCookies(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement cookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_COOKIES)));
        cookiesButton.click();
    }

    private static void createAnAccount(WebDriver driver) {
        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createAccountButton.click();
    }


    private static void selectDateOfBirth(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectComboDay = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_SELECT_DAY)));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByIndex(22); //23

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByIndex(9); // 10 -> October

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByIndex(41); // 1983
    }
}
