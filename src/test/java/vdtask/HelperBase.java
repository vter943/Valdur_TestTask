package vdtask;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }


    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    //[name='Цена от']   [id='glpricefrom'] #glpricefrom//#glpriceto
    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
