package common.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Class contains
 * -Global Locators
 * -Global Methods
 * -Basic Methods
 */
public class BaseActions {
    private WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    // Timeout value for explicit waits in seconds
    private final int waitForElementTimeout = 20;

    // Global locators
    public final By mainLogInButton = By.id("login");
    private final By mainLogOutButton = By.cssSelector("button#submit");
    private final By userNameValue = By.cssSelector("label#userName-value");
    private final By sideLogIn = By.cssSelector("div.element-list.show li#item-0");


    /////////////////////// Basic Methods ///////////////////////

    /**
     * Wait for Element
     *
     * @param locator
     */

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitForElementTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for Element to be clickable
     *
     * @param locator
     */

    public void waitForElementIsClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitForElementTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Get text
     *
     * @param locator
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText().trim();
    }

    /**
     * Click element
     *
     * @param locator
     */
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Writes on element
     *
     * @param locator
     */
    public void sendKeys(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Scroll at the bottom of the page with JS
     */
    protected void scrollBottomPageJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }


    /////////// Global Actions ////////

    /**
     * Click Log In From Main menu
     */
    public void clickMainLogIn() {
        waitForElement(mainLogInButton);
        click(mainLogInButton);
    }

    /**
     * Click Log In From Side menu
     */
    public void clickSideLogIn() {
        waitForElement(sideLogIn);
        // scroll to avoid random adds when appear
        scrollBottomPageJS();
        click(sideLogIn);
    }

    /**
     * Click Log Out
     */
    public void clickLogout() {
        waitForElementIsClickable(mainLogOutButton);
        click(mainLogOutButton);
        waitForElement(mainLogInButton);
    }

    /**
     * Returns the username shown in the UI when user is logged in
     *
     * @return
     */
    public String getUser() {
        return getText(userNameValue);
    }


}
