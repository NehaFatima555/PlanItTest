import Common.UIModule;
import ObjectRepository.AssertionTexts;
import ObjectRepository.Contacts;
import PageObjects.ContactsPage;
import PageObjects.HomePage;
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
        Assert.assertEquals(getText(Contacts.EMAIlFIELDERROR), AssertionTexts.MTEMAILMANDATORY);
        Assert.assertEquals(getText(Contacts.MESSAGEFILEDERROR), AssertionTexts.MTMESSAGEMANDATORY);

        //Populate mandatory fields
        contactsPage.populateMandatoryFields();

        //validate errors are gone
        Assert.assertTrue(checkElementDoesNotExist(Contacts.FORENAMEFIELDERROR));
        Assert.assertTrue(checkElementDoesNotExist(Contacts.EMAIlFIELDERROR));
        Assert.assertTrue(checkElementDoesNotExist(Contacts.MESSAGEFILEDERROR));

        closeDriver();
    }


}
