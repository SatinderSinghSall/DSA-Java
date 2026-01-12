// Friends Paring Problem:

/*
 == Problem Statement: ==
 * Given n friends, each one can remain single or can be paired up with some
 * other friend. Each friend can be paired only once. Find out the total number
 * of ways in which friends can remain single or can be paired up.
*/


public class FriendsParingProblem {
    public static int FriendsParingProblem_Logic(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int fnm1 = FriendsParingProblem_Logic(n - 1);
        int fnm2 = FriendsParingProblem_Logic(n - 2);
        int pairWays = (n - 1) * fnm2;
        int totalWays = fnm1 + pairWays;

        return totalWays;
    }

    public static int FriendsParingProblem_Logic_2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return FriendsParingProblem_Logic_2(n - 1) + (n - 1) * FriendsParingProblem_Logic_2(n - 2);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(FriendsParingProblem_Logic(n));
        System.out.println(FriendsParingProblem_Logic_2(n));
    }
}
