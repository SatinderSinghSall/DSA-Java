// Stack-Problem: Reverse a String using Stack:

import java.util.Stack;

public class ReverseString {
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx ++;
        }

        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Stack-Problem: Reverse a String using Stack:");

        String str = "abc";
        System.out.println(str);
        System.out.println(reverseString(str));
    }
}
