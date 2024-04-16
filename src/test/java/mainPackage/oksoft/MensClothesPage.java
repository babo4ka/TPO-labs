package mainPackage.oksoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensClothesPage {

    public WebDriver driver;

    public MensClothesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"filterItem_14\"]/h5/strong/a")
    private WebElement seasonDrop;
    @FindBy(xpath = "//*[@id=\"ChkBx_14_29\"]")
    private WebElement demiSeasonBtn;
    @FindBy(xpath = "//*[@id=\"ChkBx_14_33\"]")
    private WebElement summerSeasonBtn;


    @FindBy(xpath = "//*[@id=\"filterItem_15\"]/h5/strong/a")
    private WebElement claspTypeDrop;
    @FindBy(xpath = "//*[@id=\"ChkBx_15_30\"]")
    private WebElement pugovkaBtn;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/section/div/div[1]/div/div/div[12]/button")
    private WebElement filtersClearBtn;


    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-4\"]")
    private WebElement accInfo;

    @FindBy(xpath = "/html/body/header/nav[2]/div/div[2]/ul/li/a")
    private WebElement logoutBtn;

    @FindBy(xpath = "/html/body/header/nav[2]/div/a[1]")
    private WebElement goMainBtn;

    public void goMain(){
        new Actions(driver).scrollToElement(goMainBtn).perform();
        goMainBtn.click();
    }

    public void chooseDemiSeason(){
        new Actions(driver).scrollToElement(seasonDrop).perform();
        seasonDrop.click();
        new Actions(driver).scrollToElement(demiSeasonBtn).perform();
        demiSeasonBtn.click();
    }

    public void chooseSummer(){
        new Actions(driver).scrollToElement(seasonDrop).perform();
        seasonDrop.click();
        new Actions(driver).scrollToElement(summerSeasonBtn).perform();
        summerSeasonBtn.click();
    }

    public void chooseClasp(){
        new Actions(driver).scrollToElement(claspTypeDrop).perform();
        claspTypeDrop.click();
        new Actions(driver).scrollToElement(pugovkaBtn).perform();
        pugovkaBtn.click();
    }

    public void filtersClear(){
        new Actions(driver).scrollToElement(filtersClearBtn).perform();
        filtersClearBtn.click();
    }



    public void logout(){
        accInfo.click();
        logoutBtn.click();
    }

    public int cardsCount(){
        return driver
                .findElements(By.xpath("//*[@id=\"CatalogueSection\"]/section/div[2]/div"))
                .size();
    }
}
