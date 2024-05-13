package mainPackage.oksoft.lab3;

import mainPackage.oksoft.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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


    @FindBy(xpath = "//*[@id=\"toast-container\"]/div/div[2]")
    private WebElement errorText;

    public String checkZayavkaNegative(int sum) throws InterruptedException {
        createZayavka(sum);

        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"toast-container\"]/div/div[2]")));

        return getTextFromElement(errorText);
    }

    public String checkZayavkaWrong(String wrongText) throws InterruptedException {
        scrollToElement(openModalZayavkaBtn);
        clickElement(openModalZayavkaBtn);

        Thread.sleep(1000);

        scrollToElement(sumInput);
        sumInput.sendKeys(wrongText);

        clickElement(changeTypeBox);
        clickElement(chooseType);

        scrollToElement(createZayavkaBtn);
        clickElement(createZayavkaBtn);

        new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"toast-container\"]/div/div[2]")));

        return getTextFromElement(errorText);
    }

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
        scrollToElement(lastZayavka);
    }

    public String checkZayavka(){
        scrollToElement(zayavkaSum);

        String text = getTextFromElement(zayavkaSum);
        System.out.println(text);

        return text;
    }
}
