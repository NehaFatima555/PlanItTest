import Common.UIModule;
import ObjectRepository.AssertionTexts;
import PageObjects.ContactsPage;
import PageObjects.HomePage;
import PageObjects.SuccessPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase2 extends UIModule {
    HomePage homePage = new HomePage();
    ContactsPage contactsPage = new ContactsPage();
    SuccessPage successPage = new SuccessPage();

    @Parameters("url")
    @Test(invocationCount = 5)
    public void Test2(String url) throws Exception {

        initialiseDriver();

        //From Home Page Go to contact page
        navigateUrl(url);
        homePage.goToConatactsPage();


        //Populate mandatory fields
        contactsPage.populateMandatoryFields();

        //Click Submit button
        contactsPage.submit();

        //validate successMessage
        successPage.waitUntilPageLoads();

        Assert.assertTrue(verifyPageSourceContains(AssertionTexts.MTSUCCESSPART1));
        Assert.assertTrue(verifyPageSourceContains(AssertionTexts.MTSUCCESSPART2));

        closeDriver();
    }


}
