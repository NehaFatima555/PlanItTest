package PageObjects;

import Common.UIModule;
import ObjectRepository.Home;

public class HomePage extends UIModule {

    public void goToConatactsPage() throws Exception {
        click(Home.CONTACTSLINK);
    }

    public void goToShopPage() throws Exception {
        click(Home.SHOPLINK);
    }

    public void goToCart() throws Exception {
        click(Home.CARTLINK);
    }
}
