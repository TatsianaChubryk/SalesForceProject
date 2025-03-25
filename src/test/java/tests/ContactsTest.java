package tests;

import oblects.Account;
import oblects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactsTest extends BaseTest{

    Random random = new Random();

    @Test
    public void createContactTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80256379284");
        account.setDescription("nothing");

        Contact contact = new Contact();
        contact.setSalutation("Mr.");
        contact.setContactFirstName("Dan");
        contact.setContactLastName("Igor");
        contact.setContactAccountName(account.getAccountName());
        contact.setDescription("nothing");
        contact.setPhone("80235412359");
        contact.setContactOwner("ssas");

        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactsModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactsListPage.openPage(CONTACT_LIST_URL);
        Assert.assertEquals(contactsListPage.getExistContactName(contact.getContactFirstName(),contact.getContactLastName()), contact.getFullName());
        Assert.assertEquals(contactsListPage.getExistPhoneNumberByContactName(contact.getContactFirstName(),contact.getContactLastName()),contact.getPhone());
        Assert.assertEquals(contactsListPage.getExistContactOwnerByContactName(contact.getContactFirstName(),contact.getContactLastName()),contact.getContactOwner());
    }

    @Test
    public void checkNewContactTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80256158984");
        account.setDescription("nothing");

        Contact contact = new Contact();
        contact.setSalutation("Mr.");
        contact.setContactFirstName("Danilov");
        contact.setContactLastName("Igor");
        contact.setContactAccountName(account.getAccountName());
        contact.setDescription("nothing");
        contact.setPhone("80256158984");
        contact.setContactOwner("owner");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactsModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactsListPage.openPage(CONTACT_LIST_URL)
                .clickOnContactName(contact.getContactFirstName(),contact.getContactLastName());
        softAssertions.assertThat(contactsPage.getFieldValueByName("Name","Mr. Contact3 Contact1")).isEqualTo("Mr. Contact3 Contact1");
        softAssertions.assertThat(contactsPage.getFieldValueByName("Account Name","account7")).isEqualTo("account7");
        softAssertions.assertThat(contactsPage.getFieldValueByName("Contact Owner", "Tatsiana Chubryk")).isEqualTo("Tatsiana Chubryk");
    }
}