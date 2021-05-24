package PageObjects;

import Common.UIModule;
import org.openqa.selenium.By;

public class HomePage extends UIModule {

    public void goToConatactsPage() throws Exception{
        click(By.linkText("Contact"));
    }
}
