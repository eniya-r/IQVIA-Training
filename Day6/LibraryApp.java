import java.util.*;

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}

class Book {
    final int id;
    final String title;
    final String author;
    boolean isBorrowed;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " by " + author + (isBorrowed ? " (BORROWED)" : "");
    }
}

class User {
    final int id;
    final String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }
}

class Library {
    private final Map<Integer, Book> books = new LinkedHashMap<>();
    private final Map<Integer, User> users = new LinkedHashMap<>();

    private final Map<Integer, Integer> borrowedBy = new HashMap<>();

    private int nextBookId = 1;
    private int nextUserId = 1;

    public Book addBook(String title, String author) {
        Book b = new Book(nextBookId++, title, author);
        books.put(b.id, b);
        return b;
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }


    public User registerUser(String name) {
        User u = new User(nextUserId++, name);
        users.put(u.id, u);
        return u;
    }

    public List<User> listUsers() {
        return new ArrayList<>(users.values());
    }

    public void borrowBook(int bookId, int userId) throws BookNotFoundException, InvalidUserException {
        Book book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundException("No book with id " + bookId);
        }
        User user = users.get(userId);
        if (user == null) {
            throw new InvalidUserException("No user with id " + userId);
        }
        if (book.isBorrowed) {
            int currentUserId = borrowedBy.get(bookId);
            String currentUserName = users.get(currentUserId).name;
            System.out.println(" Book already borrowed by [" + currentUserId + "] " + currentUserName);
            return;
        }

        book.isBorrowed = true;
        borrowedBy.put(bookId, userId);
        System.out.println("Borrowed: \"" + book.title + "\" to " + user.name);
    }

    public void returnBook(int bookId) throws BookNotFoundException {
        Book book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundException("No book with id " + bookId);
        }
        if (!book.isBorrowed) {
            System.out.println("ℹ️ Book is not currently borrowed.");
            return;
        }

        book.isBorrowed = false;
        borrowedBy.remove(bookId);
        System.out.println("✅ Returned: \"" + book.title + "\"");
    }


    public void seedDemoData() {
        String[][] initialBooks = {
                {"Clean Code", "Robert C. Martin"},
                {"Effective Java", "Joshua Bloch"},
                {"The Pragmatic Programmer", "Andrew Hunt"},
                {"Head First Java", "Kathy Sierra"},
                {"Design Patterns", "Erich Gamma"},
                {"Java Concurrency in Practice", "Brian Goetz"},
                {"Refactoring", "Martin Fowler"},
                {"Test-Driven Development", "Kent Beck"},
                {"Working Effectively with Legacy Code", "Michael Feathers"},
                {"Introduction to Algorithms", "Thomas H. Cormen"}
        };
        for (String[] row : initialBooks) {
            addBook(row[0], row[1]);
        }


        String[] initialUsers = {"Alice", "Bob", "Charlie", "Diana"};
        for (String name : initialUsers) {
            registerUser(name);
        }
    }
}


public class LibraryApp {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.seedDemoData();

        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Choose option: ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter book title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter author: ");
                        String author = sc.nextLine();
                        Book b = lib.addBook(title, author);
                        System.out.println(" Added " + b);
                        break;

                    case "2":
                        System.out.print("Enter user name: ");
                        String name = sc.nextLine();
                        User u = lib.registerUser(name);
                        System.out.println("Registered " + u);
                        break;

                    case "3":
                        System.out.println("All books:");
                        for (Book bk : lib.listBooks()) {
                            System.out.println("  " + bk);
                        }
                        break;

                    case "4":
                        System.out.println("All users:");
                        for (User usr : lib.listUsers()) {
                            System.out.println("  " + usr);
                        }
                        break;

                    case "5":
                        System.out.print("Enter book id to borrow: ");
                        int borrowBookId = parseInt(sc.nextLine());
                        System.out.print("Enter user id who borrows: ");
                        int borrowUserId = parseInt(sc.nextLine());
                        lib.borrowBook(borrowBookId, borrowUserId);
                        break;

                    case "6":
                        System.out.print("Enter book id to return: ");
                        int returnBookId = parseInt(sc.nextLine());
                        lib.returnBook(returnBookId);
                        break;

                    case "7":
                        System.out.print("Enter title keyword: ");
                        String kw = sc.nextLine();
                        List<Book> found = lib.searchByTitle(kw);
                        if (found.isEmpty()) {
                            System.out.println("No books match \"" + kw + "\"");
                        } else {
                            System.out.println(" Matches:");
                            for (Book bk : found) {
                                System.out.println("  " + bk);
                            }
                        }
                        break;

                    case "0":
                        System.out.println(" Exiting Program!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Unknown option. Try again.");
                }
            } catch (BookNotFoundException | InvalidUserException ex) {
                System.out.println(" Error: " + ex.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println(" Please enter a valid number.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("============== Library Menu ==============");
        System.out.println("1) Add Book");
        System.out.println("2) Register User");
        System.out.println("3) List Books");
        System.out.println("4) List Users");
        System.out.println("5) Borrow Book");
        System.out.println("6) Return Book");
        System.out.println("7) Search Books by Title");
        System.out.println("0) Exit");
        System.out.println("==========================================");
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s.trim());
    }
}
