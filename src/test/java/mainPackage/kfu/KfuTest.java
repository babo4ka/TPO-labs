package mainPackage.kfu;

import mainPackage.config.ConfProperties;
import mainPackage.habr.HabrPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KfuTest {

    public static KfuPage kfuPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("kfupage"));

        kfuPage = new KfuPage(driver);
    }

    @Test
    public void loginTest(){
        kfuPage.openEnteringWindow();

        kfuPage.enter("EvgeAIvanov", "nn3i7l2u");
    }

}
