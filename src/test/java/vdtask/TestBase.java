package vdtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import vdtask.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    WebDriver wd;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method m) {
        logger.info("Тест стартовал успешно." + " " + m.getName());
    }

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite(enabled = true)
    public void tearDown() {
        app.stop();
    }


    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("Тест прошел успешно " + result.getMethod().getMethodName()+ "\n"
                    + "Screenshot" + app.getMarketItem().takeScreenshot());
        } else
            logger.error("Ошибка при прохождении теста " + result.getMethod().getMethodName() + "\n"
                    + "Screenshot" + app.getMarketItem().takeScreenshot());

        logger.info("тест завершен ");
        logger.info("=================================================================================");
    }
}
