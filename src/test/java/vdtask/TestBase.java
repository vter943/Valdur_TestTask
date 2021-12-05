package vdtask;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import vdtask.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    ApplicationManager app = new ApplicationManager();
    WebDriver wd;

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }

}
