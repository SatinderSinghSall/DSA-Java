// Charactor Pattern:

public class CharacterPattern {
    public static void main(String[] args) {
        int num = 5;
        char ch = 'A';
        for(int i = 1; i <= num; i ++) {
            for(int j = 1; j <= i; j ++) {
                System.out.print(ch + " ");
                ch ++;
            }
            System.out.println();
        }
    }
}
