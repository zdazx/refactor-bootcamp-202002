package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>(), new Date());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, new Date()));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk, 10.0 x 2, 20.0\n"));
        assertThat(output, containsString("biscuits, 5.0 x 5, 25.0\n"));
        assertThat(output, containsString("chocolate, 20.0 x 1, 20.0\n"));
        assertThat(output, containsString("税额: 6.5"));
        assertThat(output, containsString("总价: 71.5"));
    }

}