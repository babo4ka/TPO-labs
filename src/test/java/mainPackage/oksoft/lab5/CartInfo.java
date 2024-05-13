package mainPackage.oksoft.lab5;

public class CartInfo {

    int totalQty;
    double totalSum;
    double totalDiscount;
    double totalVp;

    public CartInfo(int totalQty, double totalSum, double totalDiscount, double totalVp) {
        this.totalQty = totalQty;
        this.totalSum = totalSum;
        this.totalDiscount = totalDiscount;
        this.totalVp = totalVp;
    }


    public boolean equals(CartInfo other) {
        return other.totalDiscount == this.totalDiscount && other.totalQty == this.totalQty
                && other.totalSum == this.totalSum && other.totalVp == this.totalVp;
    }
}
