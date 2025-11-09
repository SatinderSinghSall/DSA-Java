import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final Library library = new Library("Central Library");
    private static final Librarian librarian = new Librarian("Ananya", "LIB101");
    private static final Member member = new Member("Aman Sharma", "MEM101");

    // 🎨 ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        seedData();
        runMenu();
    }

    private static void runMenu() {
        while (true) {
            System.out.println("\n" + CYAN + "══════════════════════════════════════════════════════" + RESET);
            System.out.println(BOLD + "📚  Welcome to " + library.getName() + RESET);
            System.out.println(CYAN + "══════════════════════════════════════════════════════" + RESET);
            System.out.println(BLUE + "1.  View all library items");
            System.out.println("2.  Search for an item");
            System.out.println("3.  Borrow a book");
            System.out.println("4.  Return a book");
            System.out.println("5.  Add a new book or magazine");
            System.out.println("6.  View librarian & member details");
            System.out.println("0.  Exit" + RESET);
            System.out.println(CYAN + "──────────────────────────────────────────────────────" + RESET);

            System.out.print(YELLOW + "👉 Enter your choice: " + RESET);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) continue;
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(RED + "⚠️ Invalid input. Please enter a number." + RESET);
                continue;
            }

            switch (choice) {
                case 1 -> library.showAllItems();
                case 2 -> searchItem();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> addItem();
                case 6 -> {
                    System.out.println("\n" + BOLD + "👩‍💼 Librarian Info:" + RESET);
                    librarian.displayUser();
                    System.out.println("\n" + BOLD + "👤 Member Info:" + RESET);
                    member.displayUser();
                }
                case 0 -> {
                    System.out.println(GREEN + "\n✅ Thank you for using the Library Management System!" + RESET);
                    System.out.println(BLUE + "📖 Keep reading, keep growing!" + RESET);
                    return;
                }
                default -> System.out.println(RED + "⚠️ Invalid option. Please choose a valid number." + RESET);
            }

            System.out.println(CYAN + "──────────────────────────────────────────────────────" + RESET);
            System.out.print(YELLOW + "Press Enter to return to the main menu..." + RESET);
            sc.nextLine();
        }
    }

    private static void seedData() {
        librarian.addItem(library, new Book("B001", "Clean Code", "Robert Martin", "Programming"));
        librarian.addItem(library, new Book("B002", "Atomic Habits", "James Clear", "Self-Help"));
        librarian.addItem(library, new Magazine("M001", "National Geographic", "Various Authors", 230));
    }

    private static void searchItem() {
        System.out.print(YELLOW + "🔍 Enter title to search: " + RESET);
        String title = sc.nextLine();
        LibraryItem item = library.searchItem(title);
        if (item != null) {
            System.out.println(GREEN + "\n✅ Item found!" + RESET);
            item.displayInfo();
        } else {
            System.out.println(RED + "\n❌ Item not found in the library." + RESET);
        }
    }

    private static void borrowBook() {
        System.out.print(YELLOW + "📘 Enter book title to borrow: " + RESET);
        String title = sc.nextLine();
        LibraryItem item = library.searchItem(title);
        if (item instanceof Book book) {
            member.borrowBook(book);
        } else {
            System.out.println(RED + "❌ That item is not borrowable or doesn’t exist." + RESET);
        }
    }

    private static void returnBook() {
        System.out.print(YELLOW + "📗 Enter book title to return: " + RESET);
        String title = sc.nextLine();
        LibraryItem item = library.searchItem(title);
        if (item instanceof Book book) {
            member.returnBook(book);
        } else {
            System.out.println(RED + "❌ That item is not borrowable or doesn’t exist." + RESET);
        }
    }

    private static void addItem() {
        System.out.println(CYAN + "\n➕ Add New Item:" + RESET);
        System.out.println(BLUE + "1️⃣ Book");
        System.out.println("2️⃣ Magazine" + RESET);
        System.out.print(YELLOW + "👉 Choose type: " + RESET);

        int type;
        try {
            type = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(RED + "⚠️ Invalid input!" + RESET);
            return;
        }

        System.out.print(YELLOW + "🆔 Enter ID: " + RESET);
        String id = sc.nextLine();
        System.out.print(YELLOW + "📖 Enter Title: " + RESET);
        String title = sc.nextLine();
        System.out.print(YELLOW + "✍️ Enter Author: " + RESET);
        String author = sc.nextLine();

        if (type == 1) {
            System.out.print(YELLOW + "📚 Enter Genre: " + RESET);
            String genre = sc.nextLine();
            librarian.addItem(library, new Book(id, title, author, genre));
        } else if (type == 2) {
            System.out.print(YELLOW + "📰 Enter Issue Number: " + RESET);
            int issue = Integer.parseInt(sc.nextLine());
            librarian.addItem(library, new Magazine(id, title, author, issue));
        } else {
            System.out.println(RED + "⚠️ Invalid item type selected!" + RESET);
        }

        System.out.println(GREEN + "\n✅ Item successfully added!" + RESET);
    }
}
