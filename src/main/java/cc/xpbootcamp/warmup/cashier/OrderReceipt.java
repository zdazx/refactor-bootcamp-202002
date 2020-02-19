package cc.xpbootcamp.warmup.cashier;

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

        output.append(printCustomerInfo(order));

        output.append(printLineItems(order));

        return output.toString();
    }

    private String printHeaders() {
        StringBuilder output = new StringBuilder();
        output.append("===== 老王超市，值得信赖 ======\n");
        return output.toString();
    }

    private static String printCustomerInfo(Order order) {
        StringBuilder output = new StringBuilder();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        return output.toString();
    }

    private static String printLineItems(Order order) {
        StringBuilder output = new StringBuilder();
        double totalTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.totalAmount()).append('\n');

            totalTax += getSalesTax(lineItem);

            totalAmount += lineItem.totalAmount();
        }
        output.append(printTotalTaxAndAmount(totalTax, totalAmount));
        return output.toString();
    }

    private static String printTotalTaxAndAmount(double totalTax, double totalAmount) {
        StringBuilder output = new StringBuilder();
        output.append("Sales Tax").append('\t').append(totalTax);
        output.append("Total Amount").append('\t').append(totalAmount + totalTax);
        return output.toString();
    }

    private static double getSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }
}