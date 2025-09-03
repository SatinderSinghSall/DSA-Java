// JAVA: Character Pattern

package Practice;

public class CharacterPattern {
    public static void main(String[] args) {
        int num = 5;
        char ch = 'A';

        //Outer Loop:
        for(int i = 1; i <= num; i ++) {
            // Inner Loop:
            for(int j = 1; j <= i; j ++) {
                System.out.print(ch + " ");
                ch ++;
            }

            // Next Line:
            System.out.println();
        }
    }
}
