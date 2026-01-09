// Strings Functions: equals()

public class StringsEquals {
    public static void main(String[] args) {
        String s1 = "Satinder";
        String s2 = "Satinder";
        String s3 = new String("Satinder");

        if(s1 == s2) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }

        if(s1 == s3) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }

        if(s1.equals(s3)) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }
    }
}
