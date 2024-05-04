package mainPackage.oksoft.lab3;

import io.qameta.allure.Description;
import mainPackage.config.ConfProperties;
import mainPackage.oksoft.CommonPage;
import mainPackage.oksoft.MainPage;
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

public class OksoftTestLab3 {

    public static WebDriver driver;

    public static MainPage mainPage;
    public static CommonPage commonPage;
    public static RewardsPage rewardsPage;
    public static WalletPage walletPage;
    public static ZayavkiPage zayavkiPage;

    private static String login;
    private static String password;


    @BeforeClass
    @Parameters({"browser"})
    public static void setup(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            System.out.println(browser);
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            System.out.println(browser);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            System.out.println(driver);
        }

        System.out.println(driver instanceof FirefoxDriver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("oksoftpage"));

        login = ConfProperties.getProperty("oksoftLogin");
        password = ConfProperties.getProperty("oksoftPassword");
        commonPage = new CommonPage(driver);
        rewardsPage = new RewardsPage(driver);
        walletPage = new WalletPage(driver);
        zayavkiPage = new ZayavkiPage(driver);
        mainPage = new MainPage(driver);
    }



    @Test(priority = 1, testName = "Тестирование страницы \"Мои вознаграждения\"")
    @Description("Тестирование страницы \"Мои вознаграждения\"")
    public void testRewardsPage() throws InterruptedException {
        System.out.println("test rewards" + driver);
        mainPage.openEnteringWindow();

        mainPage.enter(login, password);

        commonPage.openRewardsPage();

        rewardsPage.checkPeriod();
    }

    @Test(priority = 2, testName = "Тестирование страницы \"Мой кошелёк\"")
    @Description("Тестирование страницы \"Мой кошелёк\"")
    public void testWalletPage() throws InterruptedException {
        System.out.println("test wallet" + driver);
        rewardsPage.openWalletPage();

        walletPage.openOperationDetails();

        int operations = walletPage.checkInterval();

        Assert.assertEquals(operations, 1);
    }


//    @Test(priority = 3)
//    @Description("Тестирование страницы \"Финансовые заявки\"")
//    public void testZayavkiPage() throws InterruptedException {
//        System.out.println("test zayavki" + driver);
//        walletPage.openZayavkiPage();
//
//        int sum = 150;
//        zayavkiPage.createZayavka(sum);
//
//        String result = "Сумма: " + sum + ",00 ₽";
//        System.out.println(zayavkiPage.checkZayavka());
//        Assert.assertEquals(zayavkiPage.checkZayavka(), result);
//    }

    @Test(priority = 4, testName = "Тестирование скролла \"Финансовые заявки\"")
    @Description("Тестирование скролла \"Финансовые заявки\"")
    public void testScrollToLast(){
        System.out.println("test scroll" + driver);
        walletPage.openZayavkiPage();
        zayavkiPage.scrollToLast();
    }

    @AfterClass
    public static void end() {
        driver.close();
    }
}
