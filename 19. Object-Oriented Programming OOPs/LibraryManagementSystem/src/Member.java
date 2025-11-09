class Member extends User {
    private int borrowedBooks = 0;

    public Member(String name, String userId) {
        super(name, userId);
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowItem();
            borrowedBooks++;
        } else {
            System.out.println("Book not available!");
        }
    }

    public void returnBook(Book book) {
        if (!book.isAvailable()) {
            book.returnItem();
            borrowedBooks--;
        } else {
            System.out.println("Book was not borrowed!");
        }
    }

    @Override
    public void displayUser() {
        System.out.println("👤 Member: " + name + " | ID: " + userId + " | Books borrowed: " + borrowedBooks);
    }
}
