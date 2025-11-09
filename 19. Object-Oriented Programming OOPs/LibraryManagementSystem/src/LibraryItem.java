abstract class LibraryItem {
    private String id;
    private String title;
    private String author;
    private boolean available = true;

    public LibraryItem(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    // Setter for availability
    public void setAvailable(boolean available) { this.available = available; }

    public abstract void displayInfo();
}
