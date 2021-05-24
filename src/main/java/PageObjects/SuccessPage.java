package PageObjects;

import Common.UIModule;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage extends UIModule {

    public void waitUntilPageLoads() throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Back")));
    }
}
