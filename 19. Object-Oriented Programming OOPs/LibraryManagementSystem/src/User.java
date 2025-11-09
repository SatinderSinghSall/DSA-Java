class User {
    protected String name;
    protected String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public void displayUser() {
        System.out.println("👤 User: " + name + " | ID: " + userId);
    }
}
