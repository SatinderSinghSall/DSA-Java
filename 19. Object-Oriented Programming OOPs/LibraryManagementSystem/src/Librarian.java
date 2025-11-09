class Librarian extends User {
    public Librarian(String name, String userId) {
        super(name, userId);
    }

    public void addItem(Library library, LibraryItem item) {
        library.addItem(item);
        System.out.println("Added new item: " + item.getTitle());
    }

    @Override
    public void displayUser() {
        System.out.println("🧾 Librarian: " + name + " | ID: " + userId);
    }
}
