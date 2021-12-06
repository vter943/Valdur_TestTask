package vdtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    EventFiringWebDriver wd;
    MainPageHelper mainPage;
    MarketItemHelper marketItem;
    MarketHeaderHelper marketHelper;


    public static class MyListener extends AbstractWebDriverEventListener {

        Logger logger = LoggerFactory.getLogger(TestBase.class);



        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Start search " +by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info(by + " found.");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error(throwable.toString());
        }
    }

    public ApplicationManager() {
        this.wd = wd;
    }

    public MainPageHelper getMainPage() {
        return mainPage;
    }

    public MarketItemHelper getMarketItem() {
        return marketItem;
    }

    public MarketHeaderHelper getMarketHelper() {
        return marketHelper;
    }

    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://yandex.ru/");

        mainPage = new MainPageHelper(wd);
        marketItem = new MarketItemHelper(wd);
        marketHelper = new MarketHeaderHelper(wd);
        wd.register(new MyListener());
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void stop() {
        wd.quit();
    }


}
