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


    @FindBy(xpath = "/html/body/div[2]/section/div/div[2]/div/div/button")
    private WebElement openModalZayavkaBtn;

    @FindBy(xpath = "//*[@id=\"Amount\"]")
    private WebElement sumInput;

    @FindBy(xpath = "//*[@id=\"modalContactForm\"]/div/div/div[2]/div[10]/div[1]/button")
    private WebElement createZayavkaBtn;

    @FindBy(xpath = "/html/body/div[2]/section/div/div[3]/section/div/div/div/div[2]/div/div[1]/p[3]")
    private WebElement zayavkaSum;

    @FindBy(xpath = "/html/body/div[2]/section/div/div[last()-1]")
    private WebElement lastZayavka;

    @FindBy(xpath = "//*[@id=\"FinOrdersOperTypes\"]")
    private WebElement changeTypeBox;

    @FindBy(xpath = "//*[@id=\"FinOrdersOperTypes\"]/option[2]")
    private WebElement chooseType;

    public void createZayavka(int sum) throws InterruptedException {

        scrollToElement(openModalZayavkaBtn);
        clickElement(openModalZayavkaBtn);

        Thread.sleep(1000);

        scrollToElement(sumInput);
        sumInput.sendKeys(String.valueOf(sum));

        clickElement(changeTypeBox);
        clickElement(chooseType);

        scrollToElement(createZayavkaBtn);
        clickElement(createZayavkaBtn);
    }

    public void scrollToLast(){
        if(driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", lastZayavka);
        }else{
            new Actions(driver).scrollToElement(lastZayavka).perform();
        }

    }

    public String checkZayavka(){
        scrollToElement(zayavkaSum);

        String text = getTextFromElement(zayavkaSum);
        System.out.println(text);

        return text;
    }
}
