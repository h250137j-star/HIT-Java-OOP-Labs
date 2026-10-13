package lab03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionAccount {
    // Private fields
    private String accountHolder;
    private double balance;

    // Private transaction history
    private final List<String> transactions = new ArrayList<>();

    // Constructor
    public TransactionAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }

        transactions.add("Opening balance: $" + this.balance);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: $" + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful!");
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Return a read-only view of transaction history
    public List<String> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    // Display account information
    public void display() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

    // Display transaction history
    public void displayTransactions() {
        System.out.println("\nTransaction History:");

        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {

        TransactionAccount account =
                new TransactionAccount("Precious", 500);

        account.deposit(200);
        account.withdraw(100);
        account.deposit(300);
        account.withdraw(50);

        account.display();
        account.displayTransactions();
    }
}
