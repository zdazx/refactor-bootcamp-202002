package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Order {
    private List<LineItem> lineItems;
    private String date;
    private boolean isHaveDiscount;
    private double totalTax;
    private double totalAmount;
    private double totalDiscount;

    public Order(List<LineItem> lineItems, Date date) {
        this.lineItems = lineItems;
        this.date = new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINA).format(date);
        this.isHaveDiscount = new SimpleDateFormat("EEEE", Locale.CHINA).format(date).equals("星期三");
        calculateBill();
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String getDate() { return date; }

    public boolean isHaveDiscount() { return isHaveDiscount; }

    public double getTotalTax() { return totalTax; }

    public double getTotalAmount() { return totalAmount; }

    public double getTotalDiscount() { return totalDiscount; }

    private void calculateBill() {
        for (LineItem lineItem : this.lineItems) {
            this.totalTax += lineItem.totalAmount() * .10;
            this.totalAmount += lineItem.totalAmount();
        }
        this.totalAmount += this.totalTax;
        if (this.isHaveDiscount) {
            this.totalDiscount = this.totalAmount * .02;
            this.totalAmount *= .98;
        }
    }
}
