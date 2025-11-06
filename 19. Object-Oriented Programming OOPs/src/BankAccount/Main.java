// 🏦 Example 1: BankAccount Class

/*
🎯 Goal: Demonstrate Encapsulation and Access Modifiers
Encapsulation means “wrapping data (variables) and methods together”
and restricting direct access to sensitive information (like balance).
We’ll use private fields and expose only safe operations using public
methods.
*/

package BankAccount;

class BankAccount {
    // 🔒 Private data: cannot be accessed directly from outside the class
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // 🏗️ Constructor to initialize account details
    public BankAccount(String accNo, String accHolder, double initialBalance) {
        accountNumber = accNo;
        accountHolderName = accHolder;
        balance = initialBalance;
    }

    // ✅ Public getter methods to read data safely
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // ✅ Public methods to modify data safely
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 🧱 Create account object
        BankAccount account = new BankAccount("ACC12345", "Satinder Singh", 5000);

        // ✅ Access details safely via public methods
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Account Balance: ₹" + account.getBalance());

        // Perform operations
        account.deposit(2000);
        account.withdraw(1500);
        System.out.println("Updated Balance: ₹" + account.getBalance());
    }
}
