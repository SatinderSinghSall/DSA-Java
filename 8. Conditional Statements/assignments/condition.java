package assignments;

public class condition {
    public static void main(String[] args) {
        int a = 56;
        int b = 76;

        boolean ans = a < b;

        if (a < b) {
            System.out.println("Yay, I am dumb!");
            a++;
            b++;
        }

        a++;

        System.out.println(ans);
    }
}
