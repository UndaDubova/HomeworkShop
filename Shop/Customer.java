package Shop;

public class Customer {
    private String username;
    private String password;
    private Customer loggedInCustomer;
    private double balance;


    public Customer(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = balance = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}


