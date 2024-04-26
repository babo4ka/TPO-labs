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

public class CommonPage {

    public WebDriver driver;

    public CommonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    //имя аккаунта
    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-4\"]/div[2]")
    protected WebElement nameText;

    //кнопка мой кабинет
    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-20\"]")
    protected WebElement accountBtn;

    //кнопка истории заказов
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[2]/li[5]/div/a[16]")
    private WebElement ordersStoryBtn;

    //кнопка мои вознаграждения
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[2]/li[5]/div/a[2]")
    private WebElement rewardsBtn;

    //кнопка каталога
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[1]/li/a")
    private WebElement dropCatalogBtn;
    //кнопка мужская одежда
    @FindBy(xpath = "//*[@id=\"navbarCollapse\"]/ul[1]/li/div/div[1]/div[1]/div/ul/li[2]/a")
    private WebElement mensClothesBtn;



    //инфо об аккаунте
    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-4\"]")
    protected WebElement accInfo;

    //кнопка выхода из профиля
    @FindBy(xpath = "/html/body/header/nav[2]/div/div[2]/ul/li/a")
    protected WebElement logoutBtn;

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

    //открывает страницу истории заказов
    public void openOrdersStoryPage(){
        new Actions(driver).scrollToElement(accountBtn).perform();
        accountBtn.click();

        new Actions(driver).scrollToElement(ordersStoryBtn).perform();
        ordersStoryBtn.click();
    }

    public void openRewardsPage(){
        new Actions(driver).scrollToElement(accountBtn).perform();
        accountBtn.click();

        new Actions(driver).scrollToElement(rewardsBtn).perform();
        rewardsBtn.click();
    }

    public String getName(){
        return nameText.getText();
    }

}
