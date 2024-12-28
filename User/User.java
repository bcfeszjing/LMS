import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class User {
    private String name;
    private int age;
    ArrayList<String> borrowedBooks;
    private Map<String, LocalDate> borrowedBooksDueDates;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void borrowBook(String bookTitle) {
        borrowedBooks.add(bookTitle);
        LocalDate dueDate = LocalDate.now().plusDays(14);
        borrowedBooksDueDates.put(bookTitle, dueDate);
        System.out.println("Book: " + bookTitle + ", Due Date: " + dueDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
    }

    public void returnBook(String bookTitle) {
        if (borrowedBooks.contains(bookTitle)) {
            borrowedBooks.remove(bookTitle);
            System.out.println(bookTitle + " has been returned successfully.");
        } else {
            System.out.println("Failed to return " + bookTitle + ". Book not found in borrowed list.");
        }
    }

    public void printBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            System.out.println("Borrowed Books:");
            for (String book : borrowedBooks) {
                System.out.println("- " + book);
            }
        }
    }

    public void checkDueDates() {
        if (borrowedBooksDueDates.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
            System.out.println("Borrowed Books Due Dates:");
            for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
                System.out.println("Book: " + entry.getKey() + ", Due Date: " + entry.getValue().format(formatter));
            }
        }
    }

    public void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        boolean overdue = false;
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
            if (entry.getValue().isBefore(today)) {
                overdue = true;
                long daysOverdue = today.toEpochDay() - entry.getValue().toEpochDay();
                System.out.println("Book: " + entry.getKey() + " is overdue by " + daysOverdue + "days.");
            }
        }
        if (!overdue) {
            System.out.println("No overdue books.");
        }
    }
}
