package lab07;

public class ThrowThrowsDemo {

    // Method declaring that it may throw an exception
    public static void withdraw(double balance, double amount)
            throws Exception {

        if (amount <= 0) {
            throw new Exception(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new Exception(
                    "Insufficient funds. Withdrawal denied."
            );
        }

        double remainingBalance = balance - amount;

        System.out.println("Withdrawal successful.");
        System.out.println("Amount withdrawn: $" + amount);
        System.out.println("Remaining balance: $" + remainingBalance);
    }

    public static void main(String[] args) {

        double balance = 500;
        double amount = 700;

        try {

            withdraw(balance, amount);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

        System.out.println("Transaction process completed.");
    }
}
