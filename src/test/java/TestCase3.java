import Common.UIModule;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase3 extends UIModule {

    @Test
    @Parameters("url")
    public void Test3(String url) throws Exception {

        initialiseDriver();

        //From Home Page Go to shop page
        navigateUrl(url);
        click(By.linkText("Shop"));

        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Buy")));

        //Click 2 times on Funny Cow
        click(By.xpath(".//h4[contains(text(),'Funny Cow')]/ancestor::li//a"));
        click(By.xpath("//h4[contains(text(),'Funny Cow')]/ancestor::li//a"));

        //click 1 time on fluffy bunny
        click(By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//a"));

        //Click on Cart menu
        click(By.partialLinkText("Cart"));
        int quantityIndex = getIndexofQuantity();

        //Verify Cart Menu
        Assert.assertEquals(
                getValueAttribute(By.xpath(".//td[contains(text(),'Funny Cow')]//parent::tr/td[" + quantityIndex + "]/input")),
                "2");

        Assert.assertEquals(
                getValueAttribute(By.xpath(".//td[contains(text(),'Fluffy Bunny')]//parent::tr/td[" + quantityIndex + "]/input")),
                "1");

        closeDriver();
    }


}
