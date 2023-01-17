package tests;

import base.BaseTests;
import common.enums.MessageTexts;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Scope of the test:
 * - Verify not successful log in when username is invalid
 * - Verify not successful log in when password is invalid
 * - Verify not successful log in when password and username are invalid
 */

public class InvalidLoginTest extends BaseTests {


    @Parameters({"username", "password"})
    @Test(alwaysRun = true, description = "User Log in with invalid username.Verify error message is displayed")
    public void testStep_1(String username, String password) {
        loginPage.logIn(username + "33#", password, true);
        Assert.assertEquals(loginPage.getMessageInvalidLogIn(), MessageTexts.Invalid_Login_Message.getMessageText());
    }

    @Parameters({"username", "password"})
    @Test(alwaysRun = true, description = "User Log in from the Side Menu with invalid password.Verify error message is displayed", dependsOnMethods = "testStep_1")
    public void testStep_2(String username, String password) {
        loginPage.logIn(username , password + "@@@", false);
        Assert.assertEquals(loginPage.getMessageInvalidLogIn(), MessageTexts.Invalid_Login_Message.getMessageText());
    }

    @Parameters({"username", "password"})
    @Test(alwaysRun = true, description = "User Log in with invalid username and password.Verify error message is displayed", dependsOnMethods = "testStep_2")
    public void testStep_3(String username, String password) {
        loginPage.logIn(username + "Gt!0" , password + "@@@", true);
        Assert.assertEquals(loginPage.getMessageInvalidLogIn(), MessageTexts.Invalid_Login_Message.getMessageText());
    }

}
