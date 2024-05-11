import java.util.*;

public class LibraryManagementSystem {

    Scanner sc = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<Book>();

    public class Book {
        int BookId;
        String BookTitle;
        int YearOfPublications;
        String AuthorName;
        String PublisherName;
        int NumberOfAvailableCopies;
        int TotalNumberOfCopies;

        public Book(int id, String Title, int yop, int num, int totalnum,
                String au, String pub) {
            this.BookId = id;
            this.BookTitle = Title;
            this.YearOfPublications = yop;
            this.AuthorName = au;
            this.PublisherName = pub;
            this.NumberOfAvailableCopies = num;
            this.TotalNumberOfCopies = totalnum;
        }

        public void GetDetails() {
            System.out.println("Book ID: " + BookId);
            System.out.println("Title: " + BookTitle);
            System.out.println("Year of Publications: " + YearOfPublications);
            System.out.println("Author Name: " + AuthorName);
            System.out.println("Publisher Name: " + PublisherName);
            System.out.println("Number of Copies: " + NumberOfAvailableCopies);
            System.out.println("Total Number of Copies: " + TotalNumberOfCopies);
        }
    }

    void default_creation() {
        books.add(new Book(1, "Book A", 1999, 1, 10, "A-1", "P-1"));
        books.add(new Book(2, "python", 1989, 8, 15, "A-1", "P-21"));
        books.add(new Book(3, "Book C", 1999, 10, 18, "A-3", "P-3"));
        books.add(new Book(4, "Book D", 1999, 0, 5, "A-4", "P-4"));
        books.add(new Book(5, "Book E", 1999, 4, 13, "A-5", "P-5"));
        books.add(new Book(6, "Book F", 1999, 2, 10, "A-1", "P-1"));
        books.add(new Book(7, "Book G", 1999, 5, 9, "A-2", "P-1"));
        books.add(new Book(8, "Book H", 1999, 3, 8, "A-3", "P-3"));
    }

    void setDetails() {
        System.out.println("Enter Book ID:");
        int bookId = sc.nextInt();
        sc.nextLine();
    
        Book found = findBook(bookId);
    
        if (found != null) {
            System.out.println("Book already exists:");
        } else {
            System.out.println("Enter new details for Book " + bookId + ":");
            System.out.println("Enter Book Title");
            String bookTitle = sc.nextLine();
            System.out.print("Year of Publications: ");
            int yearOfPublications = sc.nextInt();
            sc.nextLine();
            System.out.print("Author Name: ");
            String authorName = sc.nextLine();
            System.out.print("Publisher Name: ");
            String publisherName = sc.nextLine();
            System.out.print("Number of Copies: ");
            int newNumberOfCopies = sc.nextInt();
    
            if (newNumberOfCopies <= 0) {
                System.out.println("Invalid number of copies. The book must have at least one copy.");
                return;
            }
    
            books.add(new Book(bookId, bookTitle, yearOfPublications, newNumberOfCopies, newNumberOfCopies, authorName, publisherName));
            System.out.println("Book added successfully!");
        }
    }
    

    void issueBook() {
        System.out.println("Enter Book ID to issue:");
        int bookId = sc.nextInt();

        Book foundBook = findBook(bookId);

        if (foundBook != null) {
            if (foundBook.NumberOfAvailableCopies > 0) {
                foundBook.NumberOfAvailableCopies--;
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("No copies available for issue.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    void returnBook() {
        System.out.println("Enter Book ID to return:");
        int bookId = sc.nextInt();

        Book foundBook = findBook(bookId);

        if (foundBook != null) {
            if (foundBook.NumberOfAvailableCopies < foundBook.TotalNumberOfCopies) {
                foundBook.NumberOfAvailableCopies++;
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("All copies of the book are already returned.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    void showMenu() {
        System.out.println("__________________________________________________");
        System.out.println("Welcome To Library Management System");
        System.out.println();
        System.out.println("Choose one of the operation");
        System.out.println();
        System.out.println("1. Set Details");
        System.out.println("2. Get Details");
        System.out.println("3. Issue");
        System.out.println("4. Return");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println("__________________________________________________");
    }

    void getBookDetails(int bookId) {
        Book foundBook = findBook(bookId);

        if (foundBook != null) {
            foundBook.GetDetails();
        } else {
            System.out.println("Book not found.");
        }
    }
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.default_creation();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            library.showMenu();
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.setDetails();;
                    break;
                case 2:
                System.out.println("Enter Book ID to get details:");
                int bookId = sc.nextInt();
                library.getBookDetails(bookId);
                break;
                case 3:
                    library.issueBook();
                    break;
                case 4:
                    library.returnBook();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        sc.close();
    }
    
    private Book findBook(int bookId) {
        for (Book book : books) {
            if (book.BookId == bookId) {
                return book;
            }
        }
        return null;
    }

}