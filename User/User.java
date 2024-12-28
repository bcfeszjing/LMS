import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    ArrayList<String> borrowedBooks;

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
}
