package lab11;

public class SingletonDemo {

    // Singleton class
    static class DatabaseConnection {

        // Single instance created when the class is initialized
        private static final DatabaseConnection instance =
                new DatabaseConnection();

        // Private constructor prevents outside instantiation
        private DatabaseConnection() {
            System.out.println("Database connection object created.");
        }

        // Public method to access the single instance
        public static DatabaseConnection getInstance() {
            return instance;
        }

        public void connect() {
            System.out.println("Connected to the database.");
        }
    }

    public static void main(String[] args) {

        // Get the first reference
        DatabaseConnection connection1 =
                DatabaseConnection.getInstance();

        connection1.connect();

        // Get another reference
        DatabaseConnection connection2 =
                DatabaseConnection.getInstance();

        connection2.connect();

        // Check whether both references point to the same object
        System.out.println("\nAre both connections the same object?");
        System.out.println(connection1 == connection2);
    }
}
