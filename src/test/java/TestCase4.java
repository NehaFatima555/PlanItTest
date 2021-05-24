import Common.UIModule;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class TestCase4 extends UIModule {

    @Test
    @Parameters("url")
    public void Test3(String url) throws Exception {

        initialiseDriver();

        //From Home Page Go to shop page
        navigateUrl(url);
        click(By.linkText("Shop"));

        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Buy")));

        //Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
        click(By.xpath(".//h4[contains(text(),'Stuffed Frog')]/ancestor::li//a"));
        click(By.xpath(".//h4[contains(text(),'Stuffed Frog')]/ancestor::li//a"));

        click(By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//a"));
        click(By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//a"));
        click(By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//a"));
        click(By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//a"));
        click(By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//a"));

        click(By.xpath(".//h4[contains(text(),'Valentine Bear')]/ancestor::li//a"));

        String stuffedFrogPrice = getText(By.xpath(".//h4[contains(text(),'Stuffed Frog')]/ancestor::li//p//span"));
        String fluffyBunnyPrice = getText(By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//p//span"));
        String valentineBearPrice = getText(By.xpath(".//h4[contains(text(),'Valentine Bear')]/ancestor::li//p//span"));

        click(By.partialLinkText("Cart"));


        int priceIndex = getIndexofPrice();
        int subTotalIndex = getIndexofSubTotal();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Check Out")));

        //Verify the price for each product
        Assert.assertEquals(
                getText(By.xpath(".//td[contains(text(),'Stuffed Frog')]//parent::tr/td[" + priceIndex + "]")),
                stuffedFrogPrice);

        Assert.assertEquals(
                getText(By.xpath(".//td[contains(text(),'Fluffy Bunny')]//parent::tr/td[" + priceIndex + "]")),
                fluffyBunnyPrice);

        Assert.assertEquals(
                getText(By.xpath(".//td[contains(text(),'Valentine Bear')]//parent::tr/td[" + priceIndex + "]")),
                valentineBearPrice);

        System.out.println("//td[contains(text(),'Stuffed Frog'')]//parent::tr/td[" + subTotalIndex + "]");

        //Verify that each product’s sub total = product price * quantity
        Assert.assertEquals(getText(By.xpath(".//td[contains(text(),'Stuffed Frog')]//parent::tr/td[" + subTotalIndex + "]")),
                getActualTotal(2, stuffedFrogPrice));

        Assert.assertEquals(getText(By.xpath(".//td[contains(text(),'Fluffy Bunny')]//parent::tr/td[" + subTotalIndex + "]")),
                getActualTotal(5, fluffyBunnyPrice));

        Assert.assertEquals(getText(By.xpath(".//td[contains(text(),'Valentine Bear')]//parent::tr/td[" + subTotalIndex + "]")),
                getActualTotal(1, valentineBearPrice));

        closeDriver();
    }

    private String getActualTotal(float i, String price) {
        price = price.replace("$", "");
        String totalPrice = new BigDecimal(price).multiply(new BigDecimal(i)).toString();
        return "$" + totalPrice;
    }


}
