package lab11.librarymanagement;

//Book Inherits from the abstract LibraryItem class
public class Book extends LibraryItem {

    private String author;

    // Constructor
    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    // Getter method
    public String getAuthor() {
        return author;
    }

    // A book can be borrowed for 14 days
    @Override
    public int loanPeriodDays() {
        return 14;
    }

    // Display book information
    @Override
    public String toString() {
        return super.toString() +
                ", Author: " + author +
                ", Loan Period: " + loanPeriodDays() + " days";
    }
}
