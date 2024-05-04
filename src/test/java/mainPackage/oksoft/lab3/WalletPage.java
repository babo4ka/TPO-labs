package mainPackage.oksoft.lab3;

import mainPackage.oksoft.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class WalletPage extends CommonPage {

    public WalletPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"date_from\"]")
    private WebElement startDateInput;

    @FindBy(xpath = "//*[@id=\"date_to\"]")
    private WebElement endDateInput;

    @FindBy(xpath = "//*[@id=\"Accounts2051\"]/div/div[4]/button")
    private WebElement showOperationsBtn;

    @FindBy(xpath = "//*[@id=\"ReportForm\"]/div[1]/div[2]/div/div[2]/button")
    private WebElement showBtn;

    public void openOperationDetails(){


        if(driver instanceof FirefoxDriver) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", showOperationsBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showOperationsBtn);
        }else{
            new Actions(driver).scrollToElement(showOperationsBtn).perform();
            showOperationsBtn.click();
        }
    }

    public int checkInterval() throws InterruptedException {
        Date today = new Date();
        if(driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", startDateInput);
//            ((JavascriptExecutor) driver).executeScript(("arguments[0].value = 23.04.2015"), startDateInput);
//            ((JavascriptExecutor) driver).executeScript(("arguments[0].value = " + today.getDate() + "." + (today.getMonth()+1) + "." + (today.getYear() + 1900)), endDateInput);
            startDateInput.sendKeys("23.04.2015");

            endDateInput.sendKeys(today.getDate() + "." + (today.getMonth()+1) + "." + (today.getYear() + 1900));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showBtn);
        }else{
            new Actions(driver).scrollToElement(startDateInput).perform();
            startDateInput.sendKeys("23.04.2015");

            endDateInput.sendKeys(today.getDate() + "." + (today.getMonth()+1) + "." + (today.getYear() + 1900));

            showBtn.click();
        }

        return driver
                .findElements(By.xpath("//*[@id=\"ReportForm\"]/div[1]/div[3]/div/table/tbody/tr"))
                .size();
    }

}
