package lab11.librarymanagement;

// Custom exception for unavailable library items
public class ItemNotAvailableException extends Exception {

    public ItemNotAvailableException(String message) {
        super(message);
    }
}
