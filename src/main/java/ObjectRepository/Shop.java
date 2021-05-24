package ObjectRepository;

import org.openqa.selenium.By;

public interface Shop {
    By STUFFEDFROGPRICEFIELD = By.xpath(".//h4[contains(text(),'Stuffed Frog')]/ancestor::li//p//span");
    By FLUFFYBUNNYPRICEFIELD = By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//p//span");
    By VALENTINEBEARPRICEFIELD = By.xpath(".//h4[contains(text(),'Valentine Bear')]/ancestor::li//p//span");
    By BUYFUNNYCOWLINK = By.xpath(".//h4[contains(text(),'Funny Cow')]/ancestor::li//a");
    By BUYFLUFFYBUNNYLINK = By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//a");
    By BUYSTUFFEDFROGLINK = By.xpath(".//h4[contains(text(),'Stuffed Frog')]/ancestor::li//a");
    By BUYVALENTINEBEARLINK = By.xpath(".//h4[contains(text(),'Valentine Bear')]/ancestor::li//a");
}
