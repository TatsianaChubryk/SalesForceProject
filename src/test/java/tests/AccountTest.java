package tests;

import oblects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createAccountTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80332578960");
        account.setDescription("nothing");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
    }
}