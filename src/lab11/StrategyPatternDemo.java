package lab11;

public class StrategyPatternDemo {


    // Strategy interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Concrete Strategy 1
    static class EcoCashPayment implements PaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.printf(
                    "Paid $%.2f using EcoCash.%n", amount
            );
        }
    }

    // Concrete Strategy 2
    static class BankTransferPayment implements PaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.printf(
                    "Paid $%.2f using Bank Transfer.%n", amount
            );
        }
    }

    // Concrete Strategy 3
    static class CashPayment implements PaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.printf(
                    "Paid $%.2f using Cash.%n", amount
            );
        }
    }

    // Context class
    static class PaymentProcessor {

        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(
                PaymentStrategy paymentStrategy) {

            this.paymentStrategy = paymentStrategy;
        }

        public void processPayment(double amount) {

            if (paymentStrategy == null) {
                System.out.println(
                        "Please select a payment method."
                );
                return;
            }

            if (amount <= 0) {
                System.out.println(
                        "Payment amount must be greater than zero."
                );
                return;
            }

            paymentStrategy.pay(amount);
        }
    }

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        System.out.println("STUDENT FEES PAYMENT SYSTEM");
        System.out.println("---------------------------");

        // Pay using EcoCash
        processor.setPaymentStrategy(
                new EcoCashPayment()
        );

        processor.processPayment(150.00);

        // Change strategy to Bank Transfer
        processor.setPaymentStrategy(
                new BankTransferPayment()
        );

        processor.processPayment(250.00);

        // Change strategy to Cash
        processor.setPaymentStrategy(
                new CashPayment()
        );

        processor.processPayment(100.00);

        System.out.println(
                "\nAll payment demonstrations completed."
        );
    }
}
