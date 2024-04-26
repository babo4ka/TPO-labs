package mainPackage.oksoft.lab3;

import mainPackage.oksoft.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RewardsPage extends CommonPage {

    public RewardsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"pivotGrid_sortedpgHeader4T\"]")
    private WebElement periodBtn;

    public void checkPeriod() throws InterruptedException {
        new Actions(driver).scrollToElement(periodBtn).perform();

        periodBtn.click();
        Thread.sleep(1000);
        periodBtn.click();
    }

}
