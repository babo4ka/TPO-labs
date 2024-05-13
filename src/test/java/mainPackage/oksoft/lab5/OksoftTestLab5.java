package mainPackage.oksoft.lab5;

import io.qameta.allure.Description;
import mainPackage.config.ConfProperties;
import mainPackage.oksoft.CommonPage;
import mainPackage.oksoft.MainPage;
import mainPackage.oksoft.ScreenMaker;
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

    public static ZayavkiPage zayavkiPage;


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
        zayavkiPage = new ZayavkiPage(driver);
    }

    @AfterClass
    public static void end() {
        driver.close();
    }

    @Test(testName = "Тестирование корзины")
    @Description("Тестирование корзины")
    public void testCart(){
        commonPage.openCart();

        CartInfo cartInfoFrontend = cartPage.getCartInfo();

        ScreenMaker.takeScreenShot(driver, "корзина");

        CartInfo cartInfoApi = ApiRequests.getCartInfo();

        Assert.assertTrue(cartInfoFrontend.equals(cartInfoApi));

        cartPage.exitCartPage();
    }


//    @Test(testName = "Тестирование заявки с отрицательным значением")
//    @Description("Тестирование заявки с отрицательным значением")
//    public void testZayavkiNegative() throws InterruptedException {
//        commonPage.openZayavkiPage();
//
//        int sum = -5;
//
//        String fronendErrorText = zayavkiPage.checkZayavkaNegative(sum);
//        System.out.println(fronendErrorText);
//        Thread.sleep(3000);
//        String apiErrorText = ApiRequests.getNegativeText();
//        System.out.println(apiErrorText);
//
//        Assert.assertEquals(fronendErrorText, apiErrorText);
//    }


    @Test(testName = "Тестирование заявки с неверным значением")
    @Description("Тестирование заявки с неверным значением")
    public void testZayavkiWrong() throws InterruptedException {
        commonPage.openZayavkiPage();


        String fronendErrorText = zayavkiPage.checkZayavkaWrong("dsads");
        System.out.println(fronendErrorText);

        String apiErrorText = ApiRequests.getWrongText();
        System.out.println(apiErrorText);

        Assert.assertEquals(fronendErrorText, apiErrorText);
    }
}
