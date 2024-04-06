package mainPackage.oksoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//*[@id=\"navbar-static-login\"])[3]")
    private WebElement enterWindowButton;


    @FindBy(xpath = "//*[@id=\"ModalLoginUserName\"]")
    private WebElement loginInput;
    @FindBy(xpath = "//*[@id=\"ModalLoginPassword\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"LoginModalPanel1\"]/div[2]/div/button")
    private WebElement enterBtn;

    public void openEnteringWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id=\"navbar-static-login\"])[3]")));

        enterWindowButton.click();
    }


    public void enter(String login, String password){
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);

        enterBtn.click();
    }
}
