// Substring in Java:

public class SubString {
    public static String SubString(String str, int si, int ei) {
        String subStr = "";
        for(int i = 0; i < ei; i ++) {
            subStr = subStr + str.charAt(i);
        }

        return subStr;
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        int si = 0;
        int ei = 5;

        System.out.println(SubString(str, si, ei));
        System.out.println(str.substring(si, ei));
    }
}
