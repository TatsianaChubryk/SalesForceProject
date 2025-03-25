package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {

    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@field-label='%s']//*[text()='%s']";

    public ContactsPage(WebDriver driver){
        super(driver);
    }

    public String getFieldValueByName(String label, String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, label, name))).getText();
    }
}