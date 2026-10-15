package lab11.librarymanagement;

import java.util.Scanner;
import java.io.IOException;

// Main application for the Library Management System
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Load previously saved library records
        try {
            FileStorage.loadData(library);
            System.out.println("Library data loaded successfully!");
        } catch (IOException | IllegalArgumentException |
                 IllegalStateException e) {
            System.out.println("Error loading data: " + e.getMessage());
            System.out.println("Please check the saved CSV files.");
            return;
        }

        boolean running = true;

        while (running) {

            System.out.println("\n================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. Add DVD");
            System.out.println("3. Register Member");
            System.out.println("4. Borrow Item");
            System.out.println("5. Return Item");
            System.out.println("6. Search Items");
            System.out.println("7. Display All Items");
            System.out.println("8. Display Members");
            System.out.println("9. Display Overdue Loans");
            System.out.println("10. Save Data");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {

                    case "1":
                        System.out.print("Enter Book ID: ");
                        String bookId = scanner.nextLine();

                        System.out.print("Enter Book Title: ");
                        String bookTitle = scanner.nextLine();

                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();

                        library.addItem(
                                new Book(bookId, bookTitle, author));
                        break;

                    case "2":
                        System.out.print("Enter DVD ID: ");
                        String dvdId = scanner.nextLine();

                        System.out.print("Enter DVD Title: ");
                        String dvdTitle = scanner.nextLine();

                        System.out.print("Enter Director: ");
                        String director = scanner.nextLine();

                        library.addItem(
                                new DVD(dvdId, dvdTitle, director));
                        break;

                    case "3":
                        System.out.print("Enter Member ID: ");
                        String memberId = scanner.nextLine();

                        System.out.print("Enter Member Name: ");
                        String memberName = scanner.nextLine();

                        library.registerMember(
                                new Member(memberId, memberName));
                        break;

                    case "4":
                        System.out.print("Enter Item ID: ");
                        String borrowId = scanner.nextLine();

                        System.out.print("Enter Member ID: ");
                        String borrowerId = scanner.nextLine();

                        library.borrowItem(borrowId, borrowerId);
                        break;

                    case "5":
                        System.out.print("Enter Item ID: ");
                        String returnId = scanner.nextLine();

                        System.out.print("Enter Member ID: ");
                        String returnMember = scanner.nextLine();

                        library.returnItem(returnId, returnMember);
                        break;

                    case "6":
                        System.out.print("Enter Title to Search: ");
                        String searchTitle = scanner.nextLine();

                        library.searchItems(searchTitle);
                        break;

                    case "7":
                        library.displayItems();
                        break;

                    case "8":
                        library.displayMembers();
                        break;

                    case "9":
                        library.displayOverdueLoans();
                        break;

                    case "10":
                        FileStorage.saveData(library);
                        System.out.println("Data saved successfully!");
                        break;

                    case "0":
                        FileStorage.saveData(library);
                        System.out.println("Data saved successfully!");
                        System.out.println("Thank you for using the Library Management System!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (ItemNotAvailableException |
                     BorrowLimitExceededException |
                     IllegalArgumentException |
                     IllegalStateException |
                     IOException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
