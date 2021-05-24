import Common.UIModule;
import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase3 extends UIModule {
    HomePage homePage = new HomePage();
    ShopPage shopPage = new ShopPage();
    CartPage cartPage = new CartPage();

    @Test
    @Parameters("url")
    public void Test3(String url) throws Exception {

        initialiseDriver();

        //From Home Page Go to shop page
        navigateUrl(url);
        homePage.goToShopPage();

        shopPage.waitUntilPageLoads();

        //Click 2 times on Funny Cow
        shopPage.buyFunnyCow(2);

        //click 1 time on fluffy bunny
        shopPage.buyFluffyBunny(1);

        //Click on Cart menu
        homePage.goToCart();
        int quantityIndex = cartPage.getIndexofQuantity();

        //Verify Cart Menu
        Assert.assertEquals(
                getValueAttribute(cartPage.getFunnyCowquantity(quantityIndex)),
                "2");

        Assert.assertEquals(
                getValueAttribute(cartPage.getFluffyBunnyquantity(quantityIndex)),
                "1");

        closeDriver();
    }


}
