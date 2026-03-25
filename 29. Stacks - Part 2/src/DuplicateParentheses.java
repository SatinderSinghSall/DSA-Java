import java.util.*;

public class DuplicateParentheses {
    public static boolean hasDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing bracket
            if (ch == ')') {
                int count = 0;

                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                // remove opening bracket
                s.pop();

                if (count < 1) {
                    return true; // duplicate
                }
            } else {
                s.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(hasDuplicate(str));
    }
}
