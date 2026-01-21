# 📌 Backtracking in Java (Basics → Advanced) — Complete Guide

Backtracking is one of the most important techniques in DSA used for solving problems where we need to explore **all possible solutions** and **undo choices** when they lead to an invalid path.

This README covers:

✅ Core Theory
✅ Recursion foundation
✅ Backtracking templates
✅ Classic problems with full Java code
✅ Optimization techniques (pruning, ordering, constraints)
✅ Advanced patterns (permutations, combinations, grids, constraint satisfaction)
✅ Complexity insights
✅ Practice set

---

# 📖 Table of Contents

1. [What is Backtracking?](#-what-is-backtracking)
2. [When to Use Backtracking?](#-when-to-use-backtracking)
3. [Backtracking vs Recursion](#-backtracking-vs-recursion)
4. [Backtracking Framework](#-backtracking-framework)
5. [Core Patterns](#-core-patterns)
6. [Important Techniques](#-important-techniques)
7. [Beginner Problems](#-beginner-problems)
   - Subsets
   - Permutations
   - Combinations

8. [Intermediate Problems](#-intermediate-problems)
   - Combination Sum
   - Palindrome Partitioning
   - N-Queens

9. [Advanced Problems](#-advanced-problems)
   - Sudoku Solver
   - Word Search
   - Rat in a Maze

10. [Backtracking Optimization](#-backtracking-optimization)
11. [Complexity Analysis](#-complexity-analysis)
12. [Best Practices in Java](#-best-practices-in-java)
13. [Practice Problems List](#-practice-problems-list)

---

# 🔥 What is Backtracking?

Backtracking is an algorithmic technique where we:

1. Make a choice
2. Explore deeper (recursively)
3. If the choice leads to an invalid state → undo it (backtrack)
4. Try the next choice

📌 **Key idea:**
Backtracking explores the solution space like a **DFS (Depth First Search)** on a decision tree.

---

# 🎯 When to Use Backtracking?

Use backtracking when:

✅ You must generate **all possible solutions**
✅ You must find **one valid solution**
✅ You need to check constraints while building solution
✅ Problem involves:

- permutations / combinations
- paths in grid
- constraint satisfaction (Sudoku, N-Queens)
- subset generation

---

# 🧠 Backtracking vs Recursion

### Recursion:

Recursion is just a way of calling a function inside itself.

### Backtracking:

Backtracking is recursion **+ undoing changes**.

Example:

- recursion: compute factorial
- backtracking: generate permutations (needs undo swaps)

---

# 🏗 Backtracking Framework

### General Template

```java
void backtrack(State state) {
    if (isGoal(state)) {
        addAnswer(state);
        return;
    }

    for (Choice choice : choices(state)) {
        if (isValid(choice, state)) {
            apply(choice, state);
            backtrack(state);
            undo(choice, state);
        }
    }
}
```

---

# 🔑 Core Patterns

Backtracking mainly falls into these patterns:

## 1) Decision-based (Yes/No)

Example: Subsets (take / not take)

## 2) For-loop based

Example: combinations, partitions

## 3) Swap based

Example: permutations

## 4) Grid based

Example: Maze paths, word search

## 5) Constraint satisfaction

Example: Sudoku, N-Queens

---

# ⚙ Important Techniques

### ✅ 1. Pruning

Stop exploring a branch early if it can't lead to a valid answer.

### ✅ 2. Sorting

Helpful in avoiding duplicates.

### ✅ 3. Visited Array

Used in permutations / graph traversal.

### ✅ 4. Constraint Check

Check validity before moving deeper.

---

# 🟢 Beginner Problems

---

## ✅ 1) Subsets (Power Set)

### Problem:

Given an array, generate all subsets.

### Example:

Input: `[1,2]`
Output: `[[], [1], [2], [1,2]]`

### Java Code:

```java
import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path)); // store subset

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);           // choose
            backtrack(nums, i + 1, path, res); // explore
            path.remove(path.size() - 1); // undo
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
```

### Complexity:

- Time: **O(2^n)**
- Space: **O(n)** recursion depth

---

## ✅ 2) Permutations

### Problem:

Generate all permutations of an array.

Example: `[1,2,3]`
Output: `6 permutations`

### Java Code (Visited array approach)

```java
import java.util.*;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            path.add(nums[i]);

            backtrack(nums, used, path, res);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
```

### Complexity:

- Time: **O(n!)**
- Space: **O(n)**

---

## ✅ 3) Combinations (nCr)

### Problem:

Choose `k` numbers from `1..n`.

Example: n=4, k=2
Output: `[ [1,2], [1,3], [1,4], [2,3], [2,4], [3,4] ]`

### Java Code:

```java
import java.util.*;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
```

---

# 🟡 Intermediate Problems

---

## ✅ 4) Combination Sum (Repeat allowed)

### Problem:

Given candidates and target, find combinations that sum to target.
Each number can be reused.

Input: `[2,3,6,7]`, target = 7
Output: `[[2,2,3],[7]]`

### Java Code:

```java
import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, res); // reuse allowed
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
```

---

## ✅ 5) Palindrome Partitioning

### Problem:

Partition a string so every substring is a palindrome.

Input: `"aab"`
Output: `[["a","a","b"], ["aa","b"]]`

### Java Code:

```java
import java.util.*;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
```

---

## ✅ 6) N-Queens

### Problem:

Place `n` queens on an `n x n` board so none attack each other.

### Java Code:

```java
import java.util.*;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        backtrack(0, board, res, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    private static void backtrack(int row, char[][] board, List<List<String>> res,
                                  Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        int n = board.length;

        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (char[] r : board) sol.add(new String(r));
            res.add(sol);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col;
            int d2 = row + col;

            if (cols.contains(col) || diag1.contains(d1) || diag2.contains(d2)) continue;

            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(d1);
            diag2.add(d2);

            backtrack(row + 1, board, res, cols, diag1, diag2);

            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
```

---

# 🔴 Advanced Problems

---

## ✅ 7) Sudoku Solver (Constraint Satisfaction)

### Problem:

Fill a 9x9 Sudoku board.

### Java Code:

```java
public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) return true;

                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number
                }
            }
        }
        return true; // solved
    }

    private static boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;

            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }
}
```

---

## ✅ 8) Word Search (Grid Backtracking)

### Problem:

Check if a word exists in a grid.

Example:

```
A B C E
S F C S
A D E E
```

Word: `"ABCCED"` → true

### Java Code:

```java
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // backtrack
        return found;
    }
}
```

---

# 🚀 Backtracking Optimization

### 1) Early Stopping

If you only need **one valid solution**, return immediately once found.

### 2) Branch & Bound

Avoid exploring paths that exceed constraints.

Example:
In Combination Sum, stop if target < 0.

### 3) Sorting + Skipping Duplicates

```java
if (i > start && nums[i] == nums[i - 1]) continue;
```

Used in problems like:

- Subsets II
- Permutations II
- Combination Sum II

---

# ⏱ Complexity Analysis

Backtracking is exponential in most cases because it explores the full search space.

Common complexities:

| Problem Type | Time                                 |
| ------------ | ------------------------------------ |
| Subsets      | O(2^n)                               |
| Permutations | O(n!)                                |
| N-Queens     | ~O(n!)                               |
| Sudoku       | Worst case huge (but pruned heavily) |

---

# ✅ Best Practices in Java

### ✔ Use `ArrayList<>(path)` while storing results

Because `path` changes later.

### ✔ Always undo changes (Backtrack)

- remove last element
- unmark visited
- reset grid cell

### ✔ Prefer boolean arrays over HashSet when possible

Faster performance.

### ✔ Keep helper functions for validation

Example: `isValid()` in Sudoku / N-Queens.

---

# 📚 Practice Problems List

### Beginner

- Subsets
- Subsets II
- Permutations
- Permutations II
- Combinations
- Generate Parentheses

### Intermediate

- Combination Sum
- Combination Sum II
- Palindrome Partitioning
- Letter Combinations of Phone Number
- Restore IP Addresses

### Advanced

- N-Queens
- Sudoku Solver
- Word Search
- Rat in a Maze
- Knight’s Tour
- Cryptarithmetic
- Graph Coloring

---

# 🎯 Final Notes

Backtracking is powerful because it:

- explores all possibilities
- handles constraints naturally
- can be optimized using pruning

If you master these patterns, you can solve **90% of recursion/backtracking problems** easily.
