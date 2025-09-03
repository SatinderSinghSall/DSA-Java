//! AssignmentOperators in Java:

public class AssignmentOperators {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("Initial value of a: " + a);

        // Assignment operator
        a = 20;
        System.out.println("After assignment (a = 20): " + a);

        // Add and assign (+=)
        a += 5; // equivalent to a = a + 5
        System.out.println("After addition assignment (a += 5): " + a);

        // Subtract and assign (-=)
        a -= 3; // equivalent to a = a - 3
        System.out.println("After subtraction assignment (a -= 3): " + a);

        // Multiply and assign (*=)
        a *= 2; // equivalent to a = a * 2
        System.out.println("After multiplication assignment (a *= 2): " + a);

        // Divide and assign (/=)
        a /= 4; // equivalent to a = a / 4
        System.out.println("After division assignment (a /= 4): " + a);

        // Modulus and assign (%=)
        a %= 3; // equivalent to a = a % 3
        System.out.println("After modulus assignment (a %= 3): " + a);
    }
}
