# Data Structure and Algorithms: DSA - Java

---

# 📘Tries in Java (DSA - Sigma 4.0 / 39. Tries)

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Topic-Tries-blue)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

# Trie Data Structure (Java) — From Basics to Advanced

## 📌 Overview

This repository/document provides a complete academic and professional guide to the **Trie (Prefix Tree)** data structure. It covers:

- Theory and intuition
- Core operations (Insertion, Search)
- Advanced problems (Prefix matching, Word Break, Unique substrings, etc.)
- Algorithms and pseudocode
- Java implementations

---

## 📖 What is a Trie?

A **Trie** is a tree-based data structure used to efficiently store and retrieve strings, especially when dealing with prefixes.

### Key Characteristics

- Each node represents a character
- Root is empty
- Words are formed from root to leaf
- Common prefixes are shared

### Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| Insert    | O(L)       |
| Search    | O(L)       |
| Prefix    | O(L)       |

Where **L = length of word**

---

## 🧱 Trie Node Structure

### Problem

Design a Trie node.

### Algorithm Idea

Each node contains:

- Array of children (size 26 for lowercase letters)
- Boolean flag for end of word

### Pseudocode

```
class Node:
    children[26]
    isEndOfWord
```

### Java Code

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        isEndOfWord = false;
    }
}
```

---

## ➕ Insertion in Trie

### Problem

Insert a word into the Trie.

### Algorithm

1. Start at root
2. For each character:
   - Compute index = char - 'a'
   - If node doesn't exist → create
   - Move to next node

3. Mark last node as end of word

### Pseudocode

```
function insert(word):
    node = root
    for char in word:
        index = char - 'a'
        if node.children[index] == null:
            node.children[index] = new Node()
        node = node.children[index]
    node.isEndOfWord = true
```

### Java Code

```java
void insert(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i) - 'a';
        if (curr.children[idx] == null) {
            curr.children[idx] = new TrieNode();
        }
        curr = curr.children[idx];
    }
    curr.isEndOfWord = true;
}
```

---

## 🔍 Searching in Trie

### Problem

Check if a word exists.

### Algorithm

1. Traverse character by character
2. If any character missing → return false
3. Check endOfWord flag

### Pseudocode

```
function search(word):
    node = root
    for char in word:
        index = char - 'a'
        if node.children[index] == null:
            return false
        node = node.children[index]
    return node.isEndOfWord
```

### Java Code

```java
boolean search(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i) - 'a';
        if (curr.children[idx] == null) {
            return false;
        }
        curr = curr.children[idx];
    }
    return curr.isEndOfWord;
}
```

---

## 🔎 startsWith (Prefix Problem)

### Problem

Check if any word starts with given prefix.

### Algorithm

Similar to search but no need to check endOfWord.

### Pseudocode

```
function startsWith(prefix):
    node = root
    for char in prefix:
        if node.children[index] == null:
            return false
    return true
```

### Java Code

```java
boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
        int idx = prefix.charAt(i) - 'a';
        if (curr.children[idx] == null) {
            return false;
        }
        curr = curr.children[idx];
    }
    return true;
}
```

---

## 🧩 Word Break Problem

### Problem

Check if a string can be segmented into dictionary words.

### Algorithm

1. Use recursion
2. Try every prefix
3. If prefix exists in Trie and remaining string also valid → true

### Pseudocode

```
function wordBreak(key):
    if key is empty:
        return true
    for i from 1 to length:
        if search(prefix) and wordBreak(rest):
            return true
    return false
```

### Java Code

```java
boolean wordBreak(String key) {
    if (key.length() == 0) return true;

    for (int i = 1; i <= key.length(); i++) {
        String first = key.substring(0, i);
        String second = key.substring(i);

        if (search(first) && wordBreak(second)) {
            return true;
        }
    }
    return false;
}
```

---

## 🔠 Unique Substrings

### Problem

Count number of unique substrings.

### Algorithm

1. Insert all suffixes into Trie
2. Count total nodes

### Pseudocode

```
for i in range(n):
    insert(string[i:])
count nodes
```

### Java Code

```java
int countNodes(TrieNode root) {
    if (root == null) return 0;

    int count = 0;
    for (int i = 0; i < 26; i++) {
        if (root.children[i] != null) {
            count += countNodes(root.children[i]);
        }
    }
    return count + 1;
}
```

---

## 🔗 Longest Word with All Prefixes

### Problem

Find the longest word such that all prefixes exist.

### Algorithm

1. Insert all words
2. DFS traversal
3. Check prefix validity

### Java Code

```java
String ans = "";

void dfs(TrieNode node, StringBuilder temp) {
    if (node == null) return;

    if (node != root && !node.isEndOfWord) return;

    if (temp.length() > ans.length()) {
        ans = temp.toString();
    }

    for (int i = 0; i < 26; i++) {
        if (node.children[i] != null) {
            temp.append((char)(i + 'a'));
            dfs(node.children[i], temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
```

---

## 🧠 Complexity Summary

| Problem           | Time Complexity                 |
| ----------------- | ------------------------------- |
| Insert            | O(L)                            |
| Search            | O(L)                            |
| Prefix            | O(L)                            |
| Word Break        | Exponential (optimized with DP) |
| Unique Substrings | O(N²)                           |

---

## 🎯 Applications

- Autocomplete systems
- Spell checking
- IP routing
- Dictionary search
- Search engines

---

## 🚀 Conclusion

Trie is a powerful data structure for string-based problems. It significantly optimizes prefix-based queries and is widely used in real-world systems.

---

## 👨‍💻 Author Notes

This document is structured for:

- Academic submission
- Interview preparation
- Professional portfolio

---

**End of Document**

---

# Trie Data Structure (Java) — From Basics to Advanced

## 📌 Overview

This document provides a complete academic and professional guide to the **Trie (Prefix Tree)** data structure.

---

## 📖 What is a Trie?

A **Trie** is a tree-based data structure used to store strings efficiently.

### 🔹 Visual Representation

![Trie Example](https://upload.wikimedia.org/wikipedia/commons/b/be/Trie_example.svg)

### Key Characteristics

- Each node represents a character
- Root is empty
- Words share common prefixes

---

## 🧱 Trie Node Structure

### 🔹 Diagram

![Trie Node](https://miro.medium.com/v2/resize:fit:1400/1*3W8YwW0zZJYG1ChB7sCv0A.png)

### Problem

Design a Trie node.

### Algorithm Idea

Each node contains:

- Array of children (26)
- Boolean flag

### Pseudocode

```
class Node:
    children[26]
    isEndOfWord
```

### Java Code

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        isEndOfWord = false;
    }
}
```

---

## ➕ Insertion in Trie

### 🔹 Diagram

![Trie Insert](https://media.geeksforgeeks.org/wp-content/uploads/20220825145612/UntitledDiagramdrawio.png)

### Problem

Insert a word.

### Algorithm

1. Start from root
2. Create nodes if missing
3. Mark end

### Pseudocode

```
insert(word)
```

### Java Code

```java
void insert(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i) - 'a';
        if (curr.children[idx] == null) {
            curr.children[idx] = new TrieNode();
        }
        curr = curr.children[idx];
    }
    curr.isEndOfWord = true;
}
```

---

## 🔍 Searching in Trie

### 🔹 Diagram

![Trie Search](https://media.geeksforgeeks.org/wp-content/uploads/20220825145613/UntitledDiagramdrawio1.png)

### Problem

Search word.

### Java Code

```java
boolean search(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i) - 'a';
        if (curr.children[idx] == null) {
            return false;
        }
        curr = curr.children[idx];
    }
    return curr.isEndOfWord;
}
```

---

## 🔎 Prefix (startsWith)

### 🔹 Diagram

![Trie Prefix](https://media.geeksforgeeks.org/wp-content/uploads/20220825145614/UntitledDiagramdrawio2.png)

### Java Code

```java
boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
        int idx = prefix.charAt(i) - 'a';
        if (curr.children[idx] == null) {
            return false;
        }
        curr = curr.children[idx];
    }
    return true;
}
```

---

## 🧩 Word Break Problem

### 🔹 Diagram

![Word Break Trie](https://media.geeksforgeeks.org/wp-content/uploads/20220825145615/UntitledDiagramdrawio3.png)

### Java Code

```java
boolean wordBreak(String key) {
    if (key.length() == 0) return true;

    for (int i = 1; i <= key.length(); i++) {
        String first = key.substring(0, i);
        String second = key.substring(i);

        if (search(first) && wordBreak(second)) {
            return true;
        }
    }
    return false;
}
```

---

## 🔠 Unique Substrings

### 🔹 Diagram

![Unique Substrings Trie](https://media.geeksforgeeks.org/wp-content/uploads/20220825145616/UntitledDiagramdrawio4.png)

### Java Code

```java
int countNodes(TrieNode root) {
    if (root == null) return 0;

    int count = 0;
    for (int i = 0; i < 26; i++) {
        if (root.children[i] != null) {
            count += countNodes(root.children[i]);
        }
    }
    return count + 1;
}
```

---

## 🔗 Longest Word with All Prefixes

### 🔹 Diagram

![Longest Prefix Trie](https://media.geeksforgeeks.org/wp-content/uploads/20220825145617/UntitledDiagramdrawio5.png)

### Java Code

```java
String ans = "";

void dfs(TrieNode node, StringBuilder temp) {
    if (node == null) return;

    if (node != root && !node.isEndOfWord) return;

    if (temp.length() > ans.length()) {
        ans = temp.toString();
    }

    for (int i = 0; i < 26; i++) {
        if (node.children[i] != null) {
            temp.append((char)(i + 'a'));
            dfs(node.children[i], temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
```

---

## 🚀 Advanced Topics

### 🔹 Autocomplete System

- Use Trie + DFS

### 🔹 XOR Trie (Bit Manipulation)

- Used in maximum XOR problems

---

## 🧠 Complexity Summary

| Problem | Time |
| ------- | ---- |
| Insert  | O(L) |
| Search  | O(L) |
| Prefix  | O(L) |

---

## 🎯 Applications

- Search engines
- Autocomplete
- Spell checker

---

## 📁 Suggested GitHub Structure

```
Trie-DSA/
│── src/
│   ├── Trie.java
│   ├── WordBreak.java
│   ├── UniqueSubstring.java
│── README.md
```

---

## ✅ Conclusion

Trie is essential for string optimization problems and is widely used in real-world systems.

---

**Professional | Academic | Interview Ready**
