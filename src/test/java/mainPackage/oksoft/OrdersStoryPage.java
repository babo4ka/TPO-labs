package mainPackage.oksoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersStoryPage {

    public WebDriver driver;

    public OrdersStoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/section/nav/ul/li[last()-1]")
    private WebElement lastPaginationBtn;

    public void openLastPage(){
        System.out.println(driver.findElements(By.xpath("//*[@id=\"wrapper\"]/div/section/nav/ul/li")).size());
        new Actions(driver).scrollToElement(lastPaginationBtn).perform();
        lastPaginationBtn.click();


    }
}
