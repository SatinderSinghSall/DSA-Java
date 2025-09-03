//! Logical Operators in Java:

public class LogicalOperators {
    public static void main(String[] args) {
        boolean isAdult = true;
        boolean hasPermission = false;

        // Logical AND (&&)
        if (isAdult && hasPermission) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }

        // Logical OR (||)
        if (isAdult || hasPermission) {
            System.out.println("Partial access granted.");
        } else {
            System.out.println("No access granted.");
        }

        // Logical NOT (!)
        if (!hasPermission) {
            System.out.println("Permission not granted.");
        }
    }
}
