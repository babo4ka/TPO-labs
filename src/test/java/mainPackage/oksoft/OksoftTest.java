package mainPackage.oksoft;

import mainPackage.config.ConfProperties;
import mainPackage.habr.HabrPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OksoftTest {

    public static MainPage mainPage;
    public static WebDriver driver;

    private static String login;
    private static String password;

    @BeforeClass
    public static void setup(){
        login = ConfProperties.getProperty("oksoftLogin");
        password = ConfProperties.getProperty("oksoftPassword");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("oksoftpage"));

        mainPage = new MainPage(driver);
    }

    @Test
    public void enterTest(){
        mainPage.openEnteringWindow();

        mainPage.enter(login, password);
    }
}
