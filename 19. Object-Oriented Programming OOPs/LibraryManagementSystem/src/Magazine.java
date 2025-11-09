class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String id, String title, String author, int issueNumber) {
        super(id, title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("📰 [Magazine] " + getTitle() +
                " | Issue #" + issueNumber +
                " | Author: " + getAuthor() +
                " | Available: " + isAvailable());
    }
}
