package lab06;

public class PaymentInterfaceDemo {

    // Interface defining a payment contract
    interface Payment {
        void pay(double amount);
    }

    // First implementation: Cash payment
    static class CashPayment implements Payment {

        @Override
        public void pay(double amount) {
            System.out.println(
                    "Cash payment of $" + amount + " completed."
            );
        }
    }

    // Second implementation: Card payment
    static class CardPayment implements Payment {

        @Override
        public void pay(double amount) {
            System.out.println(
                    "Card payment of $" + amount + " completed."
            );
        }
    }

    // Third implementation: Mobile payment
    static class MobilePayment implements Payment {

        @Override
        public void pay(double amount) {
            System.out.println(
                    "Mobile payment of $" + amount + " completed."
            );
        }
    }

    public static void main(String[] args) {

        // Interface references holding different implementations
        Payment payment1 = new CashPayment();
        Payment payment2 = new CardPayment();
        Payment payment3 = new MobilePayment();

        payment1.pay(100);
        payment2.pay(250);
        payment3.pay(75);
    }
}
