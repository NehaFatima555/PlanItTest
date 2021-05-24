package PageObjects;

import Common.UIModule;
import ObjectRepository.Cart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.List;

public class CartPage extends UIModule {

    public void waitUntilPageLoads() throws Exception {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(Cart.CHECKOUTBUTTON));
    }


    public int getIndexofQuantity() throws Exception {

        Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.tagName("th"));

        int quantityIndex = 0;

        for (WebElement element : list) {
            if (element.getText().equals("Quantity")) {
                quantityIndex = list.indexOf(element) + 1;
            }
        }
        return quantityIndex;
    }

    public int getIndexofPrice() throws Exception {

        Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.tagName("th"));

        int quantityIndex = 0;

        for (WebElement element : list) {
            if (element.getText().equals("Price")) {
                quantityIndex = list.indexOf(element) + 1;
            }
        }
        return quantityIndex;
    }

    public int getIndexofSubTotal() throws Exception {

        Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.tagName("th"));

        int quantityIndex = 0;

        for (WebElement element : list) {
            if (element.getText().equals("Subtotal")) {
                quantityIndex = list.indexOf(element) + 1;
            }
        }
        return quantityIndex;
    }

    public By getFunnyCowquantity(int index) {
        return By.xpath(".//td[contains(text(),'Funny Cow')]//parent::tr/td[" + index + "]/input");
    }

    public By getFluffyBunnyquantity(int index) {
        return By.xpath(".//td[contains(text(),'Fluffy Bunny')]//parent::tr/td[" + index + "]/input");
    }

    public By getStuffedFogIndexValue(int index) {
        return By.xpath(".//td[contains(text(),'Stuffed Frog')]//parent::tr/td[" + index + "]");
    }

    public By getValentineBearIndexValue(int index) {
        return By.xpath(".//td[contains(text(),'Valentine Bear')]//parent::tr/td[" + index + "]");
    }

    public By getFluffyBunnyIndexValue(int index) {
        return By.xpath(".//td[contains(text(),'Fluffy Bunny')]//parent::tr/td[" + index + "]");
    }

    public String getActualTotal(float i, String price) {
        price = price.replace("$", "");
        String totalPrice = new BigDecimal(price).multiply(new BigDecimal(i)).toString();
        return "$" + totalPrice;
    }

}
