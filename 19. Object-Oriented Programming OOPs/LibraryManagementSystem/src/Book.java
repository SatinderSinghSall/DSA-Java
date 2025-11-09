class Book extends LibraryItem implements Borrowable {
    private String genre;

    public Book(String id, String title, String author, String genre) {
        super(id, title, author);
        this.genre = genre;
    }

    @Override
    public void borrowItem() {
        if (isAvailable()) {
            setAvailable(false);
            System.out.println(getTitle() + " has been borrowed.");
        } else {
            System.out.println("Sorry, " + getTitle() + " is not available.");
        }
    }

    @Override
    public void returnItem() {
        if (!isAvailable()) {
            setAvailable(true);
            System.out.println(getTitle() + " has been returned.");
        } else {
            System.out.println(getTitle() + " was not borrowed.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("📘 [Book] " + getTitle() + " by " + getAuthor() +
                " | Genre: " + genre + " | Available: " + isAvailable());
    }
}
