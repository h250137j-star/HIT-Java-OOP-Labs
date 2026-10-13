package lab07;

public class CustomExceptionDemo {

    // Custom checked exception
    static class InsufficientBalanceException extends Exception {

        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    // Bank account class
    static class BankAccount {

        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public void withdraw(double amount)
                throws InsufficientBalanceException {

            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Withdrawal amount must be positive."
                );
            }

            if (amount > balance) {
                throw new InsufficientBalanceException(
                        "Insufficient balance! Available balance: $" + balance
                );
            }

            balance -= amount;

            System.out.println("Withdrawal successful.");
            System.out.println("Amount withdrawn: $" + amount);
            System.out.println("Remaining balance: $" + balance);
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(500);

        try {

            account.withdraw(700);

        } catch (InsufficientBalanceException e) {

            System.out.println("Custom Exception: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Invalid Amount: " + e.getMessage());
        }

        System.out.println("Banking operation completed.");
    }
}
