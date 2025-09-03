/*
    Question - 2: 
    Finish the following code so that it prints You have a fever if your temperature is above 100 and otherwise prints You don't have a fever.
    
    public class Solution {
        public static void main(String[] args) {
            double temp = 103.5;
        }
    }
*/

package assignments;

public class questionSolution2 {
    public static void main(String[] args) {
        double temp = 103.5;

        if (temp > 100.0) {
            System.out.println("\nYou have fever!");
        } else {
            System.out.println("\nYou do not have a fever!");
        }
    }
}
