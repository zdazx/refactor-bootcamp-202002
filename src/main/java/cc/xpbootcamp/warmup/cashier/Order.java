package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItems;

    public Order(String cName, String addr, List<LineItem> lineItems) {
        this.cName = cName;
        this.addr = addr;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
