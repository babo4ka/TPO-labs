package mainPackage.habr;

import mainPackage.config.ConfProperties;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HabrTest {

    public static HabrPage habrPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("habrpage"));

        habrPage = new HabrPage(driver);
    }

    @Test
    public void searchBtnTest(){
        String text = habrPage.btnText();
        Assert.assertEquals("Войти", text);
    }

}
