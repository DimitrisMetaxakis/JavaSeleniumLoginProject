package tests;

import base.BaseTests;
import common.enums.MessageTexts;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Scope of the test:
 * - Verify successful log in from Side menu
 * - Verify successful log out
 */

public class SideValidLoginTest extends BaseTests {


    @Parameters({"username", "password"})
    @Test(alwaysRun = true, description = "User Log in with valid credentials from Side Menu.Verify user name is displayed after successful log in")
    public void testStep_1(String username, String password) {
        loginPage.logIn(username, password, false);
        Assert.assertEquals(loginPage.getUser(), username);
    }

    @Test(alwaysRun = true, description = "User logs out.Verify log out is successful", dependsOnMethods = "testStep_1")
    public void testStep_2() {
        loginPage.clickLogout();
        Assert.assertEquals(loginPage.getMessageToLogIn(), MessageTexts.Message_To_Log_In.getMessageText());
    }


}
