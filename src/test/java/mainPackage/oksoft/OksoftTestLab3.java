package mainPackage.oksoft;

import mainPackage.config.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OksoftTestLab3 {

    public static WebDriver driver;

    public static MainPage mainPage;
    public static CommonPage commonPage;


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
    }

    @Test(priority = 0)
    public void enter(){
        mainPage = new MainPage(driver);

        mainPage.openEnteringWindow();

        mainPage.enter(login, password);

        commonPage.openRewardsPage();
    }


    @AfterClass
    public static void end() throws InterruptedException {
        driver.close();
    }
}
