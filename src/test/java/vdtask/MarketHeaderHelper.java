package vdtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketHeaderHelper extends HelperBase {

    public MarketHeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void selectComputersDept() throws InterruptedException {
        click(By.cssSelector("[href*='/catalog--elektronika']"));
        pause(200);
        if (isElementPresent(By.cssSelector("button[data-text='Принять все']"))) {
            click(By.cssSelector("button[data-text='Принять все']"));
        }
    }
    public void searchItemFromSearchBox(String itemName) {
        type(By.cssSelector("#header-search"), itemName);
        click(By.cssSelector("[type=submit]"));
    }
    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

}
