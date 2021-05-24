import Common.UIModule;
import ObjectRepository.AssertionTexts;
import ObjectRepository.Contacts;
import PageObjects.ContactsPage;
import PageObjects.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 extends UIModule {
    HomePage homePage = new HomePage();
    ContactsPage contactsPage = new ContactsPage();

    @Test
    @Parameters("url")
    public void Test1(String url) throws Exception {

        initialiseDriver();

        //From Home Page Go to contact page
        navigateUrl(url);
        homePage.goToConatactsPage();

        //Click Submit button
        contactsPage.submit();

        //validate errors

        Assert.assertEquals(getText(Contacts.FORENAMEFIELDERROR), AssertionTexts.MTFORENAMEMANDATORY);
        Assert.assertEquals(getText(Contacts.EMAIlFIELDERROR),AssertionTexts.MTEMAILMANDATORY );
        Assert.assertEquals(getText(Contacts.MESSAGEFILEDERROR),AssertionTexts.MTMESSAGEMANDATORY );

        //Populate mandatory fields
        enterText(By.id("forename"), "Test");
        enterText(By.id("email"), "Test.test@test.com.au");
        enterText(By.id("message"), "Test");

        //validate errors are gone
        Assert.assertEquals(true, checkElementDoesNotExist(By.id("forename-err")));
        Assert.assertEquals(true, checkElementDoesNotExist(By.id("email-err")));
        Assert.assertEquals(true, checkElementDoesNotExist(By.id("message-err")));

        closeDriver();
    }


}
