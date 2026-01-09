// String to upper case:

public class UpperCase {
//    public static String toUpperCaseCustom(String str) {
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//
//            // Check if character is lowercase
//            if (ch >= 'a' && ch <= 'z') {
//                ch = (char) (ch - 32); // convert to uppercase
//            }
//
//            result.append(ch);
//        }
//
//        return result.toString();
//    }

    public static void main(String[] args) {
        String str = "hello world";

        // Convert to uppercase
        String upper = str.toUpperCase();

        System.out.println("Original String: " + str);
        System.out.println("Uppercase String: " + upper);
    }
}
