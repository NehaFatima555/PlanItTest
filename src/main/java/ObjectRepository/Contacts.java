package ObjectRepository;

import org.openqa.selenium.By;

public interface Contacts {
    By FORENAMEFIELDERROR = By.id("forename-err");
    By EMAIlFIELDERROR = By.id("email-err");
    By MESSAGEFILEDERROR = By.id("message-err");
    By FORENAMEFIELD = By.id("forename");
    By EMAIlFIELD = By.id("email");
    By MESSAGEFILED = By.id("message");
    By SUBMITLINK = By.linkText("Submit");
}
