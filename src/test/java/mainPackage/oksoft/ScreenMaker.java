package mainPackage.oksoft;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenMaker {

    public static void takeScreenShot(WebDriver driver, String name){
        Allure.getLifecycle().addAttachment(name, "image/png", "png",
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
    }
}
