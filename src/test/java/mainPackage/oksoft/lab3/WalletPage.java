package mainPackage.oksoft.lab3;

import mainPackage.oksoft.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
        new Actions(driver).scrollToElement(showOperationsBtn).perform();
        showOperationsBtn.click();
    }

    public int checkInterval(){
        new Actions(driver).scrollToElement(startDateInput).perform();

        startDateInput.sendKeys("23.04.2015");
        Date today = new Date();
        endDateInput.sendKeys(today.getDate() + "." + (today.getMonth()+1) + "." + (today.getYear() + 1900));

        showBtn.click();

        return driver
                .findElements(By.xpath("//*[@id=\"ReportForm\"]/div[1]/div[3]/div/table/tbody/tr"))
                .size();
    }

}
