package lab11.librarymanagement;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

// Manages library items, members and loans
public class Library {

    // Collections for storing library records
    private HashMap<String, LibraryItem> items = new HashMap<>();
    private HashMap<String, Member> members = new HashMap<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    // Add a book or DVD
    public void addItem(LibraryItem item) {

        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException(
                    "Item ID already exists.");
        }

        items.put(item.getId(), item);
        System.out.println("Item added successfully!");
    }

    // Register a library member
    public void registerMember(Member member) {

        if (members.containsKey(member.getMemberId())) {
            throw new IllegalArgumentException(
                    "Member ID already exists.");
        }

        members.put(member.getMemberId(), member);
        System.out.println("Member registered successfully!");
    }

    // Borrow a library item
    public void borrowItem(String itemId, String memberId)
            throws ItemNotAvailableException,
            BorrowLimitExceededException {

        LibraryItem item = items.get(itemId);
        Member member = members.get(memberId);

        // Check whether the item and member exist
        if (item == null || member == null) {
            throw new IllegalArgumentException(
                    "Item or member not found.");
        }

        // Check item availability
        if (!item.isAvailable()) {
            throw new ItemNotAvailableException(
                    "This item is currently unavailable.");
        }

        // Check borrowing limit
        if (!member.canBorrow()) {
            throw new BorrowLimitExceededException(
                    "Maximum borrowing limit of 3 reached.");
        }

        // Update item and member records
        member.borrowItem(itemId);
        item.borrowItem();

        // Create a new loan
        Loan loan = new Loan(
                itemId, memberId, item.loanPeriodDays());

        loans.add(loan);

        System.out.println("Item borrowed successfully!");
        System.out.println("Due date: " + loan.getDueDate());
    }

    // Return a borrowed library item
    public void returnItem(String itemId, String memberId) {

        LibraryItem item = items.get(itemId);
        Member member = members.get(memberId);

        if (item == null || member == null) {
            throw new IllegalArgumentException(
                    "Item or member not found.");
        }

        Loan activeLoan = null;

        // Find the active loan
        for (Loan loan : loans) {

            if (loan.getItemId().equals(itemId)
                    && loan.getMemberId().equals(memberId)
                    && !loan.isReturned()) {

                activeLoan = loan;
                break;
            }
        }

        if (activeLoan == null) {
            throw new IllegalArgumentException(
                    "No active loan found for this member and item.");
        }

        // Update borrowing records
        member.returnItem(itemId);
        item.returnItem();
        activeLoan.returnItem();

        System.out.println("Item returned successfully!");
    }

    // Search for library items by title
    public void searchItems(String title) {

        boolean found = false;

        for (LibraryItem item : items.values()) {

            if (item.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {

                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching items found.");
        }
    }

    // Display all books and DVDs
    public void displayItems() {

        if (items.isEmpty()) {
            System.out.println("No library items available.");
            return;
        }

        for (LibraryItem item : items.values()) {
            System.out.println(item);
        }
    }

    // Display registered library members
    public void displayMembers() {

        if (members.isEmpty()) {
            System.out.println("No registered members.");
            return;
        }

        for (Member member : members.values()) {
            System.out.println(member);
        }
    }

    // Display overdue library loans
    public void displayOverdueLoans() {

        boolean found = false;

        for (Loan loan : loans) {

            if (loan.isOverdue()) {
                System.out.println(loan);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No overdue loans.");
        }
    }

    // Get all library items for CSV storage
    public List<LibraryItem> getItems() {
        return new ArrayList<>(items.values());
    }

    // Get all members for CSV storage
    public List<Member> getMembers() {
        return new ArrayList<>(members.values());
    }

    // Get all loans for CSV storage
    public List<Loan> getLoans() {
        return new ArrayList<>(loans);
    }

    // Restore a saved loan from a CSV file
    public void restoreLoan(Loan loan) {

        LibraryItem item = items.get(loan.getItemId());
        Member member = members.get(loan.getMemberId());

        // Validate the saved loan
        if (item == null || member == null) {
            throw new IllegalArgumentException(
                    "Saved loan refers to an unknown item or member.");
        }

        // Restore active borrowing information
        if (!loan.isReturned()) {

            if (!item.isAvailable() || !member.canBorrow()) {
                throw new IllegalStateException(
                        "Invalid active loan in saved data.");
            }

            member.borrowItem(loan.getItemId());
            item.borrowItem();
        }

        // Restore the loan record
        loans.add(loan);
    }
}