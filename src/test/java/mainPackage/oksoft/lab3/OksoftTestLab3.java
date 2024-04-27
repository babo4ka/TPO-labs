package mainPackage.oksoft.lab3;

import mainPackage.config.ConfProperties;
import mainPackage.oksoft.CommonPage;
import mainPackage.oksoft.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
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
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("oksoftpage"));

        login = ConfProperties.getProperty("oksoftLogin");
        password = ConfProperties.getProperty("oksoftPassword");
        commonPage = new CommonPage(driver);
        rewardsPage = new RewardsPage(driver);
        walletPage = new WalletPage(driver);
        zayavkiPage = new ZayavkiPage(driver);
    }


    @Test(priority = 0)
    public void testRewardsPage() throws InterruptedException {
        mainPage = new MainPage(driver);

        mainPage.openEnteringWindow();

        mainPage.enter(login, password);

        commonPage.openRewardsPage();

        rewardsPage.checkPeriod();
    }

    @Test(priority = 1)
    public void testWalletPage(){
        rewardsPage.openWalletPage();
        walletPage.openOperationDetails();

        int operations = walletPage.checkInterval();

        Assert.assertEquals(operations, 1);
    }


    @Test(priority = 2)
    public void testZayavkiPage() throws InterruptedException {
        walletPage.openZayavkiPage();

        int sum = 150;
        zayavkiPage.createZayavka(sum);

        String result = "Сумма: " + sum + ",00 ₽";
        System.out.println(zayavkiPage.checkZayavka());
        Assert.assertEquals(result, zayavkiPage.checkZayavka());
    }

    @Test(priority = 3)
    public void testScrollToLast(){
        zayavkiPage.scrollToLast();
    }

    @AfterClass
    public static void end() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
