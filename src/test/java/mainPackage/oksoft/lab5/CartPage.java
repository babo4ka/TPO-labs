package mainPackage.oksoft.lab5;

import mainPackage.oksoft.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends CommonPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"totalQuantity\"]")
    private WebElement totalQtyText;

    @FindBy(xpath = "//*[@id=\"totalAmountStartPriceSum\"]")
    private WebElement totalDiscountText;

    @FindBy(xpath = "//*[@id=\"totalVp\"]")
    private WebElement totalVpText;

    @FindBy(xpath = "//*[@id=\"wholeTotalFirst\"]")
    private WebElement totalSumText;

    public CartInfo getCartInfo(){
        scrollToElement(totalQtyText);
        System.out.println("text qty " + getTextFromElement(totalQtyText));
        int totalQty = Integer.parseInt(getTextFromElement(totalQtyText));

        scrollToElement(totalDiscountText);
        double totalDiscount = Double.parseDouble(
                getTextFromElement(totalDiscountText)
                        .replaceAll("\\s+","")
                        .replaceAll(",", "."));

        scrollToElement(totalVpText);
        double totalVp = Double.parseDouble(
                getTextFromElement(totalVpText)
                        .replaceAll("\\s+","")
                        .replaceAll(",", "."));

        scrollToElement(totalSumText);
        double totalSum = Double.parseDouble(
                getTextFromElement(totalSumText)
                        .replaceAll("\\s+","")
                        .replaceAll(",", "."));

        return new CartInfo(totalQty, totalSum, totalDiscount, totalVp);
    }
}
