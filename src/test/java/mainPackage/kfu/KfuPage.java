package mainPackage.kfu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class KfuPage {

    public WebDriver driver;

    public KfuPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"page\"]/header/a[1]")
    private WebElement enterWindowBtn;

    @FindBy(xpath = "//*[@id=\"p_login\"]")
    private WebElement loginInput;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"start-auth\"]")
    private WebElement enterBtn;

    public void openEnteringWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page\"]/header/a[1]")));
        enterWindowBtn.click();
    }

    public void enter(String login, String password){
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);

        enterBtn.click();
    }
}
