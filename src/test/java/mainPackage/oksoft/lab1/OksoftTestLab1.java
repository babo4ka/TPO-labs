package mainPackage.oksoft.lab1;

import mainPackage.config.ConfProperties;

import mainPackage.oksoft.CommonPage;
import mainPackage.oksoft.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OksoftTestLab1 {

    public static MainPage mainPage;
    public static CommonPage commonPage;
    public static MensClothesPage mensClothesPage;
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
        commonPage = new CommonPage(driver);
        mensClothesPage = new MensClothesPage(driver);
    }

    @Test(priority = 0)
    public void enterTest(){
        mainPage.openEnteringWindow();

        mainPage.enter(login, password);

        Assert.assertEquals("5518\nКузнецова", commonPage.getName());
    }

    @Test(priority = 1)
    public void testFilters(){
        commonPage.openMensClothesPage();

        mensClothesPage.chooseDemiSeason();
        mensClothesPage.chooseClasp();

        Assert.assertEquals(1, mensClothesPage.cardsCount());
    }

    @Test(priority = 2)
    public void testFiltersClear(){
        mensClothesPage.filtersClear();

        Assert.assertEquals(5, mensClothesPage.cardsCount());
    }




    @AfterClass
    public static void end() throws InterruptedException {
        mensClothesPage.logout();
        Thread.sleep(1000);
        driver.close();
    }
}
