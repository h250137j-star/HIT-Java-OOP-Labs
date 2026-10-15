package lab11.librarymanagement;

// Abstract class implementing the Borrowable interface
public abstract class LibraryItem implements Borrowable {

    private String id;
    private String title;
    private boolean available;

    // Constructor
    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    // Setter for availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Borrow an item
    @Override
    public void borrowItem() {
        if (!available) {
            throw new IllegalStateException(
                    "This item is already borrowed.");
        }

        available = false;
    }

    // Return an item
    @Override
    public void returnItem() {
        if (available) {
            throw new IllegalStateException(
                    "This item has not been borrowed.");
        }

        available = true;
    }

    // Abstract method for loan duration
    public abstract int loanPeriodDays();

    // Display item information
    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: " + title +
                ", Available: " + available;
    }
}