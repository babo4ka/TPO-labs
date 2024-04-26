package mainPackage.oksoft.lab1;

import mainPackage.oksoft.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensClothesPage extends CommonPage {

    public MensClothesPage(WebDriver driver){
        super(driver);
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



    public int cardsCount(){
        return driver
                .findElements(By.xpath("//*[@id=\"CatalogueSection\"]/section/div[2]/div"))
                .size();
    }
}
