package mainPackage.oksoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrdersStoryPage {

    public WebDriver driver;

    public OrdersStoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/section/nav/ul/li[last()]")
    private WebElement nextPaginationBtn;

    @FindBy(xpath = "//*[@id=\"navbarDropdownMenuLink-4\"]")
    private WebElement accInfo;

    @FindBy(xpath = "/html/body/header/nav[2]/div/div[2]/ul/li/a")
    private WebElement logoutBtn;

    public void logout(){
        accInfo.click();
        logoutBtn.click();
    }

    private void openNextPage(){
        new Actions(driver).scrollToElement(nextPaginationBtn).perform();
        nextPaginationBtn.click();
    }


    public void countPagesAndPosts() throws InterruptedException, IOException {
        int pagesCount = 0;
        int postsCount = 0;
        do{
            pagesCount++;
            postsCount += driver.findElements(By.xpath("//*[contains(@class, 'card z-depth-1 mb-3')]")).size();
            openNextPage();
            Thread.sleep(1000);
        }while(!driver.getCurrentUrl().endsWith("#"));

        File file = new File("result.txt");
        FileWriter writer = new FileWriter(file, false);

        writer.write("Количество страниц: " + pagesCount + "\n");
        writer.write("Количество заказов: " + postsCount);

        writer.close();
    }
}
