// Subsets of a String:

public class Subsets_String {
    public static void findSubset(String str, String ans, int index) {
        // base case:
        if (index == str.length()) {
            if (ans.length() == 0) {
                System.out.println("NULL");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // recursion step:
        findSubset(str, ans + str.charAt(index), index + 1); // yes choice
        findSubset(str, ans, index + 1); // no choice
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubset(str, "", 0);
    }
}
