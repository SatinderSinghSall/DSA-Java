// Getters and Setters Example 3: BankAccount

public class Example3_BankAccount {
    public static void main(String[] args) {
        BankAccount2 ba = new BankAccount2();

        ba.setUserName("Satinder Singh");
        ba.setPassword("Satinder@123");
        ba.setBalance(5000);

        System.out.println("Account Holder: " + ba.getUserName());
        System.out.println("Balance: ₹" + ba.getBalance());
        System.out.println("Password: " + ba.getPassword()); // won't show the real password
    }
}

class BankAccount2 {
    private String userName;
    private String password;
    private double balance;

    // Setter for username
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter for username
    public String getUserName() {
        return userName;
    }

    // Setter for password
    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = password;
        } else {
            System.out.println("Password must be at least 8 characters long!");
        }
    }

    // Getter for password (secured)
    public String getPassword() {
        return "Access Denied (Password is private)";
    }

    // Setter for balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance value!");
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}
