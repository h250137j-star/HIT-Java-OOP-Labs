package lab11.librarymanagement;

// Custom exception for exceeding the borrowing limit
public class BorrowLimitExceededException extends Exception {

    public BorrowLimitExceededException(String message) {
        super(message);
    }
}
