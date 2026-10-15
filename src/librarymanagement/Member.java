package lab11.librarymanagement;

import java.util.ArrayList;

//Represents a registered library member
public class Member {

    private String memberId;
    private String name;
    private ArrayList<String> borrowedItems;

    // Constructor
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    // Getter methods
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }

    // Check if the member can borrow more items
    public boolean canBorrow() {
        return borrowedItems.size() < 3;
    }

    // Add a borrowed item
    public void borrowItem(String itemId) {
        if (!canBorrow()) {
            throw new IllegalStateException(
                    "Borrowing limit reached. Maximum is 3 items.");
        }

        if (borrowedItems.contains(itemId)) {
            throw new IllegalArgumentException(
                    "This item is already borrowed by the member.");
        }

        borrowedItems.add(itemId);
    }

    // Remove a returned item
    public void returnItem(String itemId) {
        if (!borrowedItems.remove(itemId)) {
            throw new IllegalArgumentException(
                    "This item was not borrowed by the member.");
        }
    }

    // Display member information
    @Override
    public String toString() {
        return "Member ID: " + memberId +
                ", Name: " + name +
                ", Borrowed Items: " + borrowedItems.size();
    }
}
