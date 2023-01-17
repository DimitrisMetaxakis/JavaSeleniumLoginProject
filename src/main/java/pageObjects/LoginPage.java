package pageObjects;

import common.enums.LogInFields;
import common.utilities.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseActions {
    private WebDriver driver;

    //Log In Page Locators
    private final By usernameField = By.id("userName");
    private final By passwordField = By.id("password");
    private final By newUser = By.id("newUser");
    private final By reloginMessage = By.cssSelector("label#loading-label");
    private final By needsLoginMessage = By.cssSelector("div.login-wrapper h5");
    private final By invalidLoginMessage = By.cssSelector("form#userForm p");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Fill Log In Form
     */
    public void fillLogInForm(LogInFields option, String text) {
        switch (option) {
            case username:
                waitForElement(usernameField);
                sendKeys(usernameField, text);
                break;
            case password:
                waitForElement(passwordField);
                sendKeys(passwordField, text);
                break;
            default:
        }
    }


    /**
     * Fill Log In Form and Click Log In Button
     */
    public void logIn(String username, String password, Boolean main) {
        if (main == true){
            clickMainLogIn();
        }else{
            clickSideLogIn();
        }
        fillLogInForm(LogInFields.username, username);
        fillLogInForm(LogInFields.password, password);
        clickMainLogIn();
    }

    /**
     * Returns the message shown in the UI when user
     * is already logged in and tries to log in again
     * @return
     * */
    public String getReloginMessage(){
        return getText(reloginMessage);
    }

    /**
     * Returns the message shown in the UI when user
     * is Logged out
     * @return
     * */
    public String getMessageToLogIn(){
        return getText(needsLoginMessage);
    }

    /**
     * Returns the message shown in the UI when user
     * tries Log In with invalid credentials
     * @return
     * */
    public String getMessageInvalidLogIn(){
        return getText(invalidLoginMessage);
    }




}
