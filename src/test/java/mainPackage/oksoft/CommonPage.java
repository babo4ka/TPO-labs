package mainPackage.oksoft;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CommonPage {

    public WebDriver driver;

    public CommonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    //ОБ АККАУНТЕ
    //имя аккаунта
    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-4\"]/div[2]")
    protected WebElement nameText;

    //инфо об аккаунте
    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-4\"]")
    protected WebElement accInfo;

    //кнопка выхода из аккаунта
    @FindBy(xpath = "/html/body/header/nav[2]/div/div[2]/ul/li/a")
    protected WebElement logoutBtn;

    //МОЙ КАБИНЕТ
    //кнопка мой кабинет
    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-20\"]")
    protected WebElement accountBtn;

    //кнопка истории заказов
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[2]/li[5]/div/a[16]")
    private WebElement ordersStoryBtn;
    //кнопка мои вознаграждения
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[2]/li[5]/div/a[2]")
    private WebElement rewardsBtn;
    //кнопка мой кошелёк
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[2]/li[5]/div/a[7]")
    private WebElement walletBtn;
    //кнопка финансовые заявки
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[2]/li[5]/div/a[8]")
    private WebElement zayavkiBtn;

    //КАТАЛОГ
    //кнопка каталога
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[1]/li/a")
    private WebElement dropCatalogBtn;
    //кнопка мужская одежда
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[1]/li/div/div[1]/div[1]/div/ul/li[2]/a")
    private WebElement mensClothesBtn;


    //кнопка на главную
    @FindBy(xpath = "/html/body/header/nav[2]/div/a[1]")
    protected WebElement goMainBtn;


    //возвращает на главную страницу
    public void goMain(){
        new Actions(driver).scrollToElement(goMainBtn).perform();
        goMainBtn.click();
    }

    //выход из аккаунта
    public void logout(){
        accInfo.click();
        logoutBtn.click();
    }

//    //открывает меню мой кабинет
//    public void openMyAccount(){
//        new Actions(driver).scrollToElement(accountBtn).perform();
//        accountBtn.click();
//    }

    //открывает страницу мужской одежды
    public void openMensClothesPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li/a")));
        dropCatalogBtn.click();

        mensClothesBtn.click();
    }

    //открывает меню мой кабинет
    private void openAccount(){
        if(driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", accountBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", accountBtn);
        }else{
            new Actions(driver).scrollToElement(accountBtn).perform();
            accountBtn.click();
        }

    }

    //открывает страницу истории заказов
    public void openOrdersStoryPage(){
        openAccount();

        new Actions(driver).scrollToElement(ordersStoryBtn).perform();
        ordersStoryBtn.click();
    }
    //открывает страницу вознаграждений
    public void openRewardsPage(){
        openAccount();

        new Actions(driver).scrollToElement(rewardsBtn).perform();
        rewardsBtn.click();
    }
    //открывает страницу мой кошелёк
    public void openWalletPage(){
        openAccount();

        new Actions(driver).scrollToElement(walletBtn).perform();
        walletBtn.click();
    }
    //открывает страницу с финансовыми заявками
    public void openZayavkiPage(){
        openAccount();

        if(driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", zayavkiBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", zayavkiBtn);
        }else{
            new Actions(driver).scrollToElement(zayavkiBtn).perform();
            zayavkiBtn.click();
        }

    }


    public String getName(){
        return nameText.getText();
    }

    protected void scrollToElement(WebElement element){
        if(driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        }else{
            new Actions(driver).scrollToElement(element).perform();
        }
    }

    protected void clickElement(WebElement element){
        if(driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }else{
            element.click();
        }
    }

    protected String getTextFromElement(WebElement element){
        if(driver instanceof FirefoxDriver){
            return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText", element);
        }else{
            return element.getText();
        }
    }

    protected boolean isElementSelected(By locator){
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.elementToBeSelected(locator));

        WebElement element = driver.findElement(locator);

        scrollToElement(element);
        return element.isSelected();
    }

    protected boolean isElementDisplayed(By locator){
        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement element = driver.findElement(locator);

        scrollToElement(element);
        return element.isDisplayed();
    }


}
