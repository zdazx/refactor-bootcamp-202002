package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItems;
    private String date;

    public Order(String cName, String addr, List<LineItem> lineItems, Date date) {
        this.cName = cName;
        this.addr = addr;
        this.lineItems = lineItems;
        this.date = new SimpleDateFormat("yyyy年MM月dd日 E").format(date);
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

    public String getDate() {
        return date;
    }
}
