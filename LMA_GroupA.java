
import Book.Book;
import Library.Library;
import User.User;

public class LMA_GroupA {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book("Harry Potter", "J.K. Rowling", "978-0747532743", true));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "978-0618260300", true));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "978-0618640157", true));

        // Adding users
        User user1 = new User("Alice", 22);
        User user2 = new User("Bob", 25);
        library.addUser(user1);
        library.addUser(user2);

        // Borrowing books
        library.borrowBook(user1, "Harry Potter");
        library.borrowBook(user2, "The Hobbit");
        library.borrowBook(user1, "Lord of the Rings");
        user1.returnBook("Lord of the Rings");

        // Displaying information
        library.listAvailableBooks();
        library.getBorrowedBooksForAllUsers();

        // Checking due dates and overdue books
        user1.checkDueDates();
        user2.checkDueDates();
        user1.checkOverdueBooks();
        user2.checkOverdueBooks();
    }
}