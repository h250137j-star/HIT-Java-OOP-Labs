package lab11;

public class FactoryPatternDemo {

    // Common interface for notifications
    interface Notification {
        void sendMessage(String message);
    }

    // Email notification class
    static class EmailNotification implements Notification {

        @Override
        public void sendMessage(String message) {
            System.out.println("Email Notification: " + message);
        }
    }

    // SMS notification class
    static class SMSNotification implements Notification {

        @Override
        public void sendMessage(String message) {
            System.out.println("SMS Notification: " + message);
        }
    }

    // Push notification class
    static class PushNotification implements Notification {

        @Override
        public void sendMessage(String message) {
            System.out.println("Push Notification: " + message);
        }
    }

    // Factory class responsible for creating objects
    static class NotificationFactory {

        public static Notification createNotification(String type) {

            if (type == null) {
                throw new IllegalArgumentException(
                        "Notification type cannot be null."
                );
            }

            switch (type.toUpperCase()) {

                case "EMAIL":
                    return new EmailNotification();

                case "SMS":
                    return new SMSNotification();

                case "PUSH":
                    return new PushNotification();

                default:
                    throw new IllegalArgumentException(
                            "Unknown notification type: " + type
                    );
            }
        }
    }

    public static void main(String[] args) {

        // Create notifications through the factory
        Notification email =
                NotificationFactory.createNotification("EMAIL");

        Notification sms =
                NotificationFactory.createNotification("SMS");

        Notification push =
                NotificationFactory.createNotification("PUSH");

        // Send messages
        email.sendMessage("Welcome to the university portal!");

        sms.sendMessage("Your registration is successful.");

        push.sendMessage("You have a new announcement.");

        System.out.println("\nProgram completed successfully.");
    }
}
