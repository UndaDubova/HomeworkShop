package Shop;

public class Sale {
    public Customer customer;
    public Product product;

    public Sale(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
    }

    public String getCustomer() {
        String name = this.customer.getUsername();
        double balance = this.customer.getBalance();
        String productName = this.product.getName();
        double producPrice = this.product.getPrice();
        double productQuantity = this.product.getQuantity();
        return "Customer " + name + " bought " + productName + " for " + producPrice + " eur. \n " +
                "Balance left was " + balance + " leftover quantity of " + productName + " is " + productQuantity;
    }

}
