package mainPackage.oksoft.lab3;

import com.beust.ah.A;
import mainPackage.oksoft.CommonPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ZayavkiPage extends CommonPage {

    public ZayavkiPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[1]/section/div/div[2]/div/div/button")
    private WebElement openModalZayavkaBtn;

    @FindBy(xpath = "//*[@id=\"Amount\"]")
    private WebElement sumInput;

    @FindBy(xpath = "//*[@id=\"modalContactForm\"]/div/div/div[2]/div[10]/div[1]/button")
    private WebElement createZayavkaBtn;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[1]/section/div/div[3]/section/div[1]/div/div/div[2]/div/div[1]/p[3]")
    private WebElement zayavkaSum;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[1]/section/div/div[3]/section/div[last()]")
    private WebElement lastZayavka;

    @FindBy(xpath = "//*[@id=\"FinOrdersOperTypes\"]")
    private WebElement changeTypeBox;

    @FindBy(xpath = "//*[@id=\"FinOrdersOperTypes\"]/option[2]")
    private WebElement chooseType;

    public void createZayavka(int sum) throws InterruptedException {
        if(driver instanceof FirefoxDriver){

        }else{
            new Actions(driver).scrollToElement(openModalZayavkaBtn).perform();
            openModalZayavkaBtn.click();

            Thread.sleep(1000);
            new Actions(driver).scrollToElement(sumInput).perform();
            sumInput.sendKeys(String.valueOf(sum));

            changeTypeBox.click();
            chooseType.click();

            new Actions(driver).scrollToElement(createZayavkaBtn).perform();
            createZayavkaBtn.click();
        }


    }

    public void scrollToLast(){
        if(driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", lastZayavka);
        }else{
            new Actions(driver).scrollToElement(lastZayavka).perform();
        }

    }

    public String checkZayavka(){
        new Actions(driver).scrollToElement(zayavkaSum).perform();
        return zayavkaSum.getText();
    }
}
