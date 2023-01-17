package navigation;

import common.utilities.BaseActions;
import org.openqa.selenium.WebDriver;

/**
 * Class contains browser window actions
 * */
public class WindowManager extends BaseActions {

    private WebDriver driver;
    private WebDriver.Navigation navigate;


    public WindowManager(WebDriver driver) {
        super(driver);
        this.driver = driver;
        navigate = driver.navigate();
    }

    /** Click go back from browser */
    public void goBack() {
        navigate.back();
    }

    /** Click go forward from browser */
    public void goForward() {
        navigate.forward();
    }

    /** Click refresh page */
    public void refreshPage() {
        navigate.refresh();
    }


}

