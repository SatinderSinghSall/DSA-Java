//! break statement: Java

public class breakStatement {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("Number = 3; loop break...EXIT");
                break;
            }

            System.out.println(i);
        }

        System.out.println("===== for Loop Exit! =====");
    }
}
