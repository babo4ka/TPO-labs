package mainPackage.oksoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class AuthorizedPage {

    public WebDriver driver;

    public AuthorizedPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-4\"]/div[2]")
    private WebElement nameText;

    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[1]/li/a")
    private WebElement dropCatalogBtn;
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[1]/li/div/div[1]/div[1]/div/ul/li[2]/a")
    private WebElement mensClothesBtn;


    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-20\"]")
    private WebElement accountBtn;

    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[2]/li[5]/div/a[16]")
    private WebElement ordersStoryBtn;

    public void openMensClothesPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li/a")));
        dropCatalogBtn.click();

        mensClothesBtn.click();
    }


    public void openOrdersStoryPage(){
        new Actions(driver).scrollToElement(accountBtn).perform();
        accountBtn.click();

        new Actions(driver).scrollToElement(ordersStoryBtn).perform();
        ordersStoryBtn.click();
    }

    public String getName(){
        return nameText.getText();
    }
}
