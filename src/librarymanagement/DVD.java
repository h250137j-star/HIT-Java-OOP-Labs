package lab11.librarymanagement;

// DVD inherits from the abstract LibraryItem class
public class DVD extends LibraryItem {

    private String director;

    // Constructor
    public DVD(String id, String title, String director) {
        super(id, title);
        this.director = director;
    }

    // Getter method
    public String getDirector() {
        return director;
    }

    // DVDs can be borrowed for 7 days
    @Override
    public int loanPeriodDays() {
        return 7;
    }

    // Display DVD information
    @Override
    public String toString() {
        return super.toString() +
                ", Director: " + director +
                ", Loan Period: " + loanPeriodDays() + " days";
    }
}
