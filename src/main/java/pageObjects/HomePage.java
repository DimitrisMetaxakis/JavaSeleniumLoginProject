package pageObjects;

import common.utilities.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseActions {
    private WebDriver driver;

    //Home Page Locators
    private final By booksArea = By.cssSelector("div.books-wrapper");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }




}
