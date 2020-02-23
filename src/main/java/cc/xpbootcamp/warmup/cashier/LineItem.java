package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private String desc;
    private double price;
    private int qty;

    public LineItem(String desc, double price, int qty) {
        super();
        this.desc = desc;
        this.price = price;
        this.qty = qty;
    }

    public String getDescription() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return qty;
    }

    double totalAmount() {
        return price * qty;
    }
}