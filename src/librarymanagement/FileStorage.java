package lab11.librarymanagement;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

// Handles saving and loading library records
public class FileStorage {

    private static final String ITEMS_FILE = "items.csv";
    private static final String MEMBERS_FILE = "members.csv";
    private static final String LOANS_FILE = "loans.csv";

    // Save all library records
    public static void saveData(Library library) throws IOException {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(ITEMS_FILE))) {

            for (LibraryItem item : library.getItems()) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    writeRow(writer, "Book", book.getId(),
                            book.getTitle(), book.getAuthor());
                } else if (item instanceof DVD) {
                    DVD dvd = (DVD) item;
                    writeRow(writer, "DVD", dvd.getId(),
                            dvd.getTitle(), dvd.getDirector());
                }
            }
        }

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(MEMBERS_FILE))) {

            for (Member member : library.getMembers()) {
                writeRow(writer, member.getMemberId(),
                        member.getName());
            }
        }

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(LOANS_FILE))) {

            for (Loan loan : library.getLoans()) {
                writeRow(writer, loan.getItemId(),
                        loan.getMemberId(),
                        loan.getBorrowDate().toString(),
                        loan.getDueDate().toString(),
                        String.valueOf(loan.isReturned()));
            }
        }
    }

    // Load saved records into the library
    public static void loadData(Library library) throws IOException {

        File itemsFile = new File(ITEMS_FILE);
        if (itemsFile.exists()) {
            try (BufferedReader reader = new BufferedReader(
                    new FileReader(itemsFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    List<String> data = parseRow(line);
                    if (data.size() != 4) {
                        throw new IOException("Invalid item record.");
                    }

                    LibraryItem item;
                    if (data.get(0).equals("Book")) {
                        item = new Book(data.get(1),
                                data.get(2), data.get(3));
                    } else if (data.get(0).equals("DVD")) {
                        item = new DVD(data.get(1),
                                data.get(2), data.get(3));
                    } else {
                        throw new IOException("Unknown item type.");
                    }

                    library.addItem(item);
                }
            }
        }

        File membersFile = new File(MEMBERS_FILE);
        if (membersFile.exists()) {
            try (BufferedReader reader = new BufferedReader(
                    new FileReader(membersFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    List<String> data = parseRow(line);
                    if (data.size() != 2) {
                        throw new IOException("Invalid member record.");
                    }

                    library.registerMember(
                            new Member(data.get(0), data.get(1)));
                }
            }
        }

        File loansFile = new File(LOANS_FILE);
        if (loansFile.exists()) {
            try (BufferedReader reader = new BufferedReader(
                    new FileReader(loansFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    List<String> data = parseRow(line);
                    if (data.size() != 5) {
                        throw new IOException("Invalid loan record.");
                    }

                    Loan loan = new Loan(
                            data.get(0),
                            data.get(1),
                            LocalDate.parse(data.get(2)),
                            LocalDate.parse(data.get(3)),
                            Boolean.parseBoolean(data.get(4)));

                    library.restoreLoan(loan);
                }
            }
        }
    }

    // Write a CSV row, including escaped special characters
    private static void writeRow(PrintWriter writer, String... values) {
        StringBuilder row = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                row.append(",");
            }

            String value = values[i];
            row.append("\"")
                    .append(value.replace("\"", "\"\""))
                    .append("\"");
        }

        writer.println(row);
    }

    // Read a CSV row with support for quoted commas
    private static List<String> parseRow(String line) throws IOException {
        List<String> values = new java.util.ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean quoted = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '"') {
                if (quoted && i + 1 < line.length()
                        && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else {
                    quoted = !quoted;
                }
            } else if (ch == ',' && !quoted) {
                values.add(current.toString());
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }

        if (quoted) {
            throw new IOException("Unclosed CSV quotation.");
        }

        values.add(current.toString());
        return values;
    }
}
