import Common.UIModule;
import ObjectRepository.Shop;
import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase4 extends UIModule {
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();
    ShopPage shopPage = new ShopPage();

    @Test
    @Parameters("url")
    public void Test4(String url) throws Exception {

        initialiseDriver();

        //From Home Page Go to shop page
        navigateUrl(url);
        homePage.goToShopPage();

        shopPage.waitUntilPageLoads();

        //Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
        shopPage.buyStuffedFrog(2);

        shopPage.buyFluffyBunny(5);

        shopPage.buyValentineBear(3);

        String stuffedFrogPrice = getText(Shop.STUFFEDFROGPRICEFIELD);
        String fluffyBunnyPrice = getText(Shop.FLUFFYBUNNYPRICEFIELD);
        String valentineBearPrice = getText(Shop.VALENTINEBEARPRICEFIELD);

        homePage.goToCart();


        int priceIndex = cartPage.getIndexofPrice();
        int subTotalIndex = cartPage.getIndexofSubTotal();


        //Verify the price for each product
        Assert.assertEquals(
                getText(cartPage.getStuffedFogIndexValue(priceIndex)),
                stuffedFrogPrice);

        Assert.assertEquals(
                getText(cartPage.getFluffyBunnyIndexValue(priceIndex)),
                fluffyBunnyPrice);

        Assert.assertEquals(
                getText(cartPage.getValentineBearIndexValue(priceIndex)),
                valentineBearPrice);


        //Verify that each product’s sub total = product price * quantity
        Assert.assertEquals(getText(cartPage.getStuffedFogIndexValue(subTotalIndex)),
                cartPage.getActualTotal(2, stuffedFrogPrice));

        Assert.assertEquals(getText(cartPage.getFluffyBunnyIndexValue(subTotalIndex)),
                cartPage.getActualTotal(5, fluffyBunnyPrice));

        Assert.assertEquals(getText(cartPage.getValentineBearIndexValue(subTotalIndex)),
                cartPage.getActualTotal(3, valentineBearPrice));

        closeDriver();
    }


}
