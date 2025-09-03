package Practice;

public class isEven {
    public static boolean CheckIsEven(int num) {
        boolean isEven = true;
        if(num % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }

        return isEven;
    }

    public static void main(String[] args) {
        System.out.println(CheckIsEven(3));
    }
}
