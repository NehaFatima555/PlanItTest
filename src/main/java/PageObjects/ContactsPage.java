package PageObjects;

import Common.UIModule;
import org.openqa.selenium.By;

public class ContactsPage extends UIModule {

    public void submit() throws Exception{
        click(By.linkText("Submit"));
    }
}
