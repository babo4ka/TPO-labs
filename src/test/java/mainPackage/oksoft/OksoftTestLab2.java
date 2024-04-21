package mainPackage.oksoft;

import mainPackage.config.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OksoftTestLab2 {

    public static MainPage mainPage;
    public static AuthorizedPage authorizedPage;
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
        authorizedPage = new AuthorizedPage(driver);
        ordersStoryPage = new OrdersStoryPage(driver);
    }


    @Test
    public void testPagination() throws InterruptedException, IOException {
        mainPage.openEnteringWindow();

        mainPage.enter(login, password);

        authorizedPage.openOrdersStoryPage();

        ordersStoryPage.countPagesAndPosts();
    }

    @AfterClass
    public static void end() throws InterruptedException {
        ordersStoryPage.logout();
        Thread.sleep(1000);
        driver.close();
    }

}
