package PageObjects;

import Common.UIModule;
import ObjectRepository.Contacts;

public class ContactsPage extends UIModule {

    public void submit() throws Exception {
        click(Contacts.SUBMITLINK);
    }

    public void populateMandatoryFields() throws Exception {
        enterText(Contacts.FORENAMEFIELD, "Test");
        enterText(Contacts.EMAIlFIELD, "Test.test@test.com.au");
        enterText(Contacts.MESSAGEFILED, "Test");
    }
}
