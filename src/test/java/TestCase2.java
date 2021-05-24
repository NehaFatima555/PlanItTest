import Common.UIModule;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase2 extends UIModule {

    @Test(invocationCount = 5)
    @Parameters("url")
    public void Test2(String url) throws Exception {

        initialiseDriver();

        //From Home Page Go to contact page
        navigateUrl(url);
        click(By.linkText("Contact"));


        //Populate mandatory fields
        enterText(By.id("forename"), "Test");
        enterText(By.id("email"), "Test.test@test.com.au");
        enterText(By.id("message"), "Test");

        //Click Submit button
        click(By.linkText("Submit"));

        //validate successMessage
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Back")));
        Assert.assertTrue(verifyPageSourceContains("Thanks Test"));
        Assert.assertTrue(verifyPageSourceContains("we appreciate your feedback."));

        closeDriver();
    }


}
