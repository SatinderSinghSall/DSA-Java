// Remove Duplicate String:

public class RemoveDuplicateString {
    public static void RemoveDuplicateString_Logic(String str, int idx, StringBuilder newString, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            RemoveDuplicateString_Logic(str, idx + 1, newString, map);
        } else {
            map[currChar - 'a'] = true;
            RemoveDuplicateString_Logic(str, idx + 1, newString.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "apnacollege";
        RemoveDuplicateString_Logic(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
