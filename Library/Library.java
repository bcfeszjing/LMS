import Book.Book;
import User.User; 

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Method to add a user to the library system
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    // Method to list all available books
    public void listAvailableBooks() {
        System.out.println("Available books in the library:");
        books.stream()
            .filter(Book::isAvailable)
            .forEach(book -> System.out.println(book.getTitle()));
    }

    // Method to print the borrowed books for each user
    public void getBorrowedBooksForAllUsers() {
        System.out.println("Borrowed books by each user:");
        for (User user : users) {
            System.out.println(user.getName() + "'s borrowed books:");
            user.printBorrowedBooks();
        }
    }

    // Modify the borrowBook method using a lambda expression to filter available books
    public void borrowBook(User user, String title) {
        List<Book> availableBooks = books.stream()
            .filter(book -> book.getTitle().equalsIgnoreCase(title) && book.isAvailable())
            .collect(Collectors.toList());

        if (!availableBooks.isEmpty()) {
            Book bookToBorrow = availableBooks.get(0);  // Get the first available book
            bookToBorrow.setAvailable(false);
            user.borrowBook(bookToBorrow.getTitle());
            System.out.println("The book '" + title + "' has been borrowed by " + user.getName());
        } else {
            System.out.println("The book '" + title + "' is either unavailable or not found.");
        }
    }

    // Display all books with their availability status
    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " (" + (book.isAvailable() ? "Available" : "Borrowed") + ")");
        }
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Method to search for books by title
    public void searchByTitle(String title) {
        System.out.println("Searching for books with title containing: " + title);
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found: " + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with title containing: " + title);
        }
    }
}