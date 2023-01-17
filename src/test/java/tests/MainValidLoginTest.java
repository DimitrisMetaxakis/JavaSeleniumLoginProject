package tests;

import base.BaseTests;
import common.enums.MessageTexts;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Scope of the test:
 * - Verify successful log in from Top menu
 * - Verify user cannot re-log in
 * - Verify successful log out
 */

public class MainValidLoginTest extends BaseTests {


    @Parameters({"username", "password"})
    @Test(alwaysRun = true, description = "User Log in with valid credentials.Verify user name is displayed after successful log in")
    public void testStep_1(String username, String password) {
        loginPage.logIn(username, password, true);
        Assert.assertEquals(loginPage.getUser(), username);
    }

    @Test(alwaysRun = true, description = "User tries to log in from side Menu.Verify user is informed that is already logged in", dependsOnMethods = "testStep_1")
    public void testStep_2() {
        loginPage.clickSideLogIn();
        Assert.assertEquals(loginPage.getReloginMessage(), MessageTexts.Already_LoggedIn_Message.getMessageText());
    }

    @Test(alwaysRun = true, description = "User logs out.Verify log out is successful", dependsOnMethods = "testStep_2")
    public void testStep_3() {
        loginPage.clickLogout();
        Assert.assertEquals(loginPage.getMessageToLogIn(), MessageTexts.Message_To_Log_In.getMessageText());
    }


}
