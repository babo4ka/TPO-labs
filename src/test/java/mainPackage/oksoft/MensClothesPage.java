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

    public void chooseDemiSeason(){
        seasonDrop.click();
        demiSeasonBtn.click();
    }

    public void chooseSummer(){
        seasonDrop.click();
        summerSeasonBtn.click();
    }

    public void chooseClasp(){
        claspTypeDrop.click();
        pugovkaBtn.click();
    }

    public void filtersClear(){
        new Actions(driver).scrollToElement(filtersClearBtn).perform();
        filtersClearBtn.click();
    }

    public int cardsCount(){
        return driver
                .findElements(By.xpath("//*[@id=\"CatalogueSection\"]/section/div[2]/div"))
                .size();
    }
}
