package pageObjects;

import common.utilities.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BaseActions {
    private WebDriver driver;

    //Account page Locators
    private final By usernameValue = By.id("userName-value");
    private final By accountTable = By.cssSelector("div.profile-wrapper");
    private final By goToBookstoreButton = By.id("gotoStore");
    private final By deleteAccountButton = By.cssSelector("div.buttonWrap button#submit nth-child(0)");
    private final By deleteAllBooksButton = By.cssSelector("div.buttonWrap button#submit nth-child(1)");

    public ProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
