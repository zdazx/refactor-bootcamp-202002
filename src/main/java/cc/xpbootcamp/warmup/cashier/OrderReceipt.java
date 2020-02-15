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

        printHeaders(output);

        printCustomerInfo(output, order);

        printLineItems(output, order);

        return output.toString();
    }

    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }

    private static void printCustomerInfo(StringBuilder output, Order order) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private static void printLineItems(StringBuilder output, Order order) {
        double totalTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            totalTax += getSalesTax(lineItem);

            totalAmount += lineItem.totalAmount();
        }
        printTotalTaxAndAmount(output, totalTax, totalAmount);

    }

    private static void printTotalTaxAndAmount(StringBuilder output, double totalTax, double totalAmount) {
        output.append("Sales Tax").append('\t').append(totalTax);
        output.append("Total Amount").append('\t').append(totalAmount + totalTax);
    }

    private static double getSalesTax(LineItem lineItem) {
        return lineItem.totalAmount() * .10;
    }
}