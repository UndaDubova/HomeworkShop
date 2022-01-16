package Shop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Shop {
    private String shopName;
    private ArrayList<Customer> customers;
    private Customer loggedInCustomer;
    public ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Sale> sales = new ArrayList<>();

    public Shop(String name) {
        this.shopName = name;
        customers = new ArrayList<>();
    }

    public String getShopName() {
        return shopName;
    }

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public void createAccount() {
        String username = getUsername();
        String password = getPassword();
        Customer newCustomer = new Customer(username, password);
        customers.add(newCustomer);

    }

    private String getUsername() {
        String username = "test";
        boolean exists = true;
        while (exists) {
            username = JOptionPane.showInputDialog("Enter username");
            exists = checkExists(username);
            if (exists) {
                JOptionPane.showMessageDialog(null, "Name taken, please choose another name");
            }
        }
        return username;
    }
    private String getPassword() {
        String password = "";
        boolean doubleChecked = false;
        while (!doubleChecked) {
            password = JOptionPane.showInputDialog("Please input your password");
            String password2 = JOptionPane.showInputDialog("Please repeat your password");
            if (password.equals(password2)) {
                doubleChecked = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Passwords don't match, try again");
            }
        }
        return password;
    }
    private boolean checkExists(String username) {
        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;

    }

    public Customer logIn() {
        loggedInCustomer = null;
        String logInUsername = JOptionPane.showInputDialog("Enter username");
        String logInPassword = JOptionPane.showInputDialog("Please input your password");
        boolean exists = false;
        while (!exists) {
            exists = checkExists(logInUsername);
            if (exists) {
                if (checkPassword(logInUsername, logInPassword)) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Log in attempt was unsuccessful");
                }
            } else {
                JOptionPane.showMessageDialog(null, "You need to create an account first ");
                break;
            }
        }
        return loggedInCustomer;
    }

    public boolean checkPassword(String username, String password) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUsername().equals(username)) {
                if (customers.get(i).getPassword().equals(password)) {
                    loggedInCustomer = customers.get(i);
                    return true;
                }
            }
        }
        return false;
    }

    public String addProduct() {
        String name = JOptionPane.showInputDialog("Enter product name");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter product price"));
        double quantity = Double.parseDouble(JOptionPane.showInputDialog("Enter product quantity"));
        Product product = new Product(name, price, quantity);
        this.products.add(product);


        return "Product added successfully";
    }

    public String buyProduct() {
        if (this.products.size() > 0) {
            Product productToBuy = (Product) JOptionPane.showInputDialog(
                    null,
                    "Select product to buy",
                    "Buy product",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    this.products.toArray(),
                    this.products.toArray()[0]
            );
            if (productToBuy.getPrice() < loggedInCustomer.getBalance()) {
                double updatedBalance = loggedInCustomer.getBalance() - productToBuy.getPrice();
                loggedInCustomer.setBalance(updatedBalance);
                double updatedQuantity = productToBuy.getQuantity() - 1;
                productToBuy.setQuantity(updatedQuantity);
                Sale sale1 = new Sale(loggedInCustomer, productToBuy);
                this.sales.add(sale1);
                return "You successfully purchased " + productToBuy.name + " for " + productToBuy.getPrice();

            } else {
                return "You don't have enough money";
            }
        } else {
            return "There are no products available yet";
        }
    }


    public String checkWallet() {
        double myBalance = loggedInCustomer.getBalance();
        if (this.sales.size() > 0) {
            return "Your balance is: " + myBalance + "eur; \n" + " Your purchase history: " + this.sales.get(0).getCustomer();
        } else {
            return "Your balance is: " + myBalance + "eur; \n";
        }
    }

    public String addToWallet() {
        double addBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount you want to add to your balance"));
        double myBalance = loggedInCustomer.getBalance();
        loggedInCustomer.setBalance(myBalance + addBalance);

        return "You just added " + addBalance + " Your current balance is: " + loggedInCustomer.getBalance() + " eur";
    }

    public String logOut() {
        loggedInCustomer = null;
        return "Hope to see you soon, goodbye!";
    }
}
