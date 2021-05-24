package ObjectRepository;

import org.openqa.selenium.By;

public interface Home {
    By CONTACTSLINK = By.linkText("Contact");
    By SHOPLINK = By.linkText("Shop");
    By CARTLINK = By.partialLinkText("Cart");
}
