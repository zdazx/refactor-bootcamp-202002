package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

class OrderReceiptTest {

    private SimpleDateFormat sdf;

    @BeforeEach
    void setUp() {
        sdf = new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINA);
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInfo() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINA);
        Date date = sdf.parse("2020年2月19日 星期三");
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, date));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力, 21.50 x 2, 43.00\n"));
        assertThat(output, containsString("小白菜, 10.00 x 1, 10.00\n"));
        assertThat(output, containsString("税额: 5.30"));
        assertThat(output, containsString("折扣: 1.17"));
        assertThat(output, containsString("总价: 57.13"));

    }

    @Test
    public void shouldPrintAllOrderInfo() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINA);
        Date date = sdf.parse("2020年2月19日 星期三");
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, date));

        String output = receipt.printReceipt();

        String expected =
                "===== 老王超市，值得信赖 ======\n" +
                "\n" +
                "2020年02月19日 星期三\n" +
                "\n" +
                "巧克力, 21.50 x 2, 43.00\n" +
                "小白菜, 10.00 x 1, 10.00\n" +
                "-----------------------------------\n" +
                "税额: 5.30\n" +
                "折扣: 1.17\n" +
                "总价: 57.13\n";

        assertThat(output, is(expected));

    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.00, 2));
            add(new LineItem("biscuits", 5.00, 5));
            add(new LineItem("chocolate", 20.00, 1));
        }};
        Date date = sdf.parse("2020年2月18日 星期二");
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, date));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk, 10.00 x 2, 20.00\n"));
        assertThat(output, containsString("biscuits, 5.00 x 5, 25.00\n"));
        assertThat(output, containsString("chocolate, 20.00 x 1, 20.00\n"));
        assertThat(output, containsString("税额: 6.50"));
        assertThat(output, containsString("总价: 71.50"));
    }

}