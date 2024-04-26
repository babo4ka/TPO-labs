package mainPackage.oksoft.lab2;

import mainPackage.config.ConfProperties;


import mainPackage.oksoft.CommonPage;
import mainPackage.oksoft.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OksoftTestLab2 {

    public static MainPage mainPage;
    public static CommonPage commonPage;
    public static OrdersStoryPage ordersStoryPage;
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
        ordersStoryPage = new OrdersStoryPage(driver);
    }


    @Test
    public void testPagination() throws InterruptedException, IOException {
        mainPage.openEnteringWindow();

        mainPage.enter(login, password);

        commonPage.openOrdersStoryPage();

        ordersStoryPage.countPagesAndPosts();
    }

    @AfterClass
    public static void end() throws InterruptedException {
        ordersStoryPage.logout();
        Thread.sleep(1000);
        driver.close();
    }

}
