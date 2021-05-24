package PageObjects;

import Common.UIModule;
import ObjectRepository.Shop;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends UIModule {

    public void waitUntilPageLoads() throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Buy")));
    }

    public void buyFunnyCow(int number) throws Exception {
        for (int i = 0; i < number; i++) {
            click(Shop.BUYFUNNYCOWLINK);
        }
    }

    public void buyFluffyBunny(int number) throws Exception {
        for (int i = 0; i < number; i++) {
            click(Shop.BUYFLUFFYBUNNYLINK);
        }

    }

    public void buyStuffedFrog(int number) throws Exception {
        for (int i = 0; i < number; i++) {
            click(Shop.BUYSTUFFEDFROGLINK);
        }

    }

    public void buyValentineBear(int number) throws Exception {
        for (int i = 0; i < number; i++) {
            click(Shop.BUYVALENTINEBEARLINK);
        }

    }
}
