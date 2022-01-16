import Shop.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop1 = new Shop("My shop");
        String shopName = shop1.getShopName();
        JOptionPane.showMessageDialog(null, "Hi welcome to " + shopName);

        String again = "Continue";
        while (again.equals("Continue")) {

            String[] choiceTwo = {"Create a new account", "Log in"};
            String firstChoice = (String) JOptionPane.showInputDialog(
                    null,
                    "Select what you want to do from available options",
                    "Main window",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choiceTwo,
                    choiceTwo[0]
            );
            if (firstChoice.equals("Create a new account")) {
                shop1.createAccount();
            }
            if (firstChoice.equals("Log in")) {
                shop1.logIn();
            }
            while (shop1.getLoggedInCustomer() != null) {

                String[] choiceThree = {"Add a product", "Buy a product", "Check wallet", "Add to wallet", "Log out"};
                String choiceSwitch = (String) JOptionPane.showInputDialog(
                        null,
                        "Select what you want to do from available options",
                        "Main window",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        choiceThree,
                        choiceThree[0]
                );
                switch (choiceSwitch) {
                    case "Add a product":
                        JOptionPane.showMessageDialog(null, shop1.addProduct());
                        break;
                    case "Buy a product":
                        JOptionPane.showMessageDialog(null, shop1.buyProduct());
                        break;
                    case "Check wallet":
                        JOptionPane.showMessageDialog(null, shop1.checkWallet());
                        break;
                    case "Add to wallet":
                        JOptionPane.showMessageDialog(null, shop1.addToWallet());
                        break;
                    //shop1.addBalance
                    case "Log out":
                        JOptionPane.showMessageDialog(null, shop1.logOut());
                        break;

                }
            }


            String[] choices = {"Continue", "Exit"};

            again = (String) JOptionPane.showInputDialog(
                    null,
                    "Do you want to continue or exit the shop?",
                    "Main window",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]
            );


            if (again.equals("Exit")) {
                JOptionPane.showMessageDialog(null, "Have a good day and see you next time!");
            }
        }
    }
}

