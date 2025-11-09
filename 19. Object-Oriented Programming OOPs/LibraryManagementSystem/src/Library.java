import java.util.*;

class Library {
    private String name;
    private List<LibraryItem> items = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void showAllItems() {
        System.out.println("\n📚 Library: " + name);
        for (LibraryItem item : items) {
            item.displayInfo();
        }
    }

    public LibraryItem searchItem(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }
}
