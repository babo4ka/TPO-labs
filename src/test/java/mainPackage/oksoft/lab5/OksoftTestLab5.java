package mainPackage.oksoft.lab5;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import mainPackage.config.ConfProperties;
import mainPackage.oksoft.CommonPage;
import mainPackage.oksoft.MainPage;
import mainPackage.oksoft.lab3.RewardsPage;
import mainPackage.oksoft.lab3.WalletPage;
import mainPackage.oksoft.lab3.ZayavkiPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OksoftTestLab5 {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static CommonPage commonPage;
    public static CartPage cartPage;


    private static String login;
    private static String password;

    @BeforeClass
    @Parameters({"browser"})
    public static void setup(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("oksoftpage"));

        login = ConfProperties.getProperty("oksoftLogin");
        password = ConfProperties.getProperty("oksoftPassword");

        mainPage = new MainPage(driver);
        mainPage.openEnteringWindow();
        mainPage.enter(login, password);

        commonPage = new CommonPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterClass
    public static void end() {
        driver.close();
    }

    @Test
    public void testCart(){
        commonPage.openCart();

        CartInfo cartInfoFrontend = cartPage.getCartInfo();

        CartApi ca = new CartApi();
        CartInfo cartInfoApi = ca.getCartInfo();

        Assert.assertTrue(cartInfoFrontend.equals(cartInfoApi));
    }
}
