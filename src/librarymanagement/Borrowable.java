package lab11.librarymanagement;

// Interface for library borrowing operations
public interface Borrowable {

    // Borrow an item
    void borrowItem();

    // Return an item
    void returnItem();

    // Check whether an item is available
    boolean isAvailable();
}
