package lab11.librarymanagement;

import java.time.LocalDate;

// Represents a library borrowing transaction
public class Loan {

    private String itemId;
    private String memberId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private boolean returned;

    // Constructor
    public Loan(String itemId, String memberId, int loanDays) {
        this(itemId, memberId, LocalDate.now(),
                LocalDate.now().plusDays(loanDays), false);
    }

    // Constructor for loading saved loan records
    public Loan(String itemId, String memberId,
                LocalDate borrowDate, LocalDate dueDate,
                boolean returned) {
        this.itemId = itemId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returned = returned;
    }

    // Getter methods
    public String getItemId() {
        return itemId;
    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    // Mark an item as returned
    public void returnItem() {
        returned = true;
    }

    // Check whether a loan is overdue
    public boolean isOverdue() {
        return !returned && LocalDate.now().isAfter(dueDate);
    }

    // Display loan information
    @Override
    public String toString() {
        return "Item ID: " + itemId +
                ", Member ID: " + memberId +
                ", Borrowed: " + borrowDate +
                ", Due: " + dueDate +
                ", Returned: " + returned +
                ", Overdue: " + isOverdue();
    }
}