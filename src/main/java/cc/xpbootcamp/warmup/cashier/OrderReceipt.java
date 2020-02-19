package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return toPrintReceipt();
    }

    private String toPrintReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(printHeaders());

        output.append('\n');

        output.append(printOrderInfo(order));

        output.append('\n');

        output.append(printLineItems(order));

        return output.toString();
    }

    private String printHeaders() {
        StringBuilder output = new StringBuilder();
        output.append("===== 老王超市，值得信赖 ======\n");
        return output.toString();
    }

    private static String printOrderInfo(Order order) {
        StringBuilder output = new StringBuilder();
        output.append(order.getDate());
        return output.toString();
    }

    private static String printLineItems(Order order) {
        StringBuilder output = new StringBuilder();
        double totalTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append(", ");
            DecimalFormat df = new DecimalFormat("#.00");
            output.append(df.format(lineItem.getPrice())).append(" x ");
            output.append(lineItem.getQuantity()).append(", ");
            output.append(df.format(lineItem.totalAmount())).append('\n');

            totalTax += getSalesTax(lineItem);

            totalAmount += lineItem.totalAmount();
        }
        output.append("-----------------------------------\n");
        output.append(printTotalTaxAndAmount(order, totalTax, totalAmount));
        return output.toString();
    }

    private static String printTotalTaxAndAmount(Order order, double totalTax, double totalAmount) {
        StringBuilder output = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");
        output.append("税额").append(": ").append(df.format(totalTax)).append('\n');
        if (order.isHaveDiscount()) {
            output.append("折扣").append(": ").append(df.format((totalAmount + totalTax) * 0.02)).append('\n');
            output.append("总价").append(": ").append(df.format((totalAmount + totalTax) * 0.98)).append('\n');
        }
        output.append("总价").append(": ").append(df.format((totalAmount + totalTax))).append('\n');

        return output.toString();
    }

    private static double getSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }
}