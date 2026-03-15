# Linked List Data Structures and Algorithms in Java

## Overview

This repository contains a comprehensive implementation of **Linked List Data Structures in Java**, covering both fundamental operations and advanced algorithmic problems.

The goal of this project is to demonstrate a clear understanding of **Data Structures and Algorithms (DSA)** through the implementation of linked list operations from scratch.

The implementations include:

- Core Linked List Structure
- Insertion and Deletion Operations
- Searching Techniques
- List Reversal
- Palindrome Checking
- Removing Nodes from the End
- Cycle Detection and Removal using Floyd’s Algorithm

These implementations are designed for **academic learning, technical interviews, and practical understanding of DSA concepts**.

---

# Table of Contents

1. Introduction to Linked Lists
2. Node Structure
3. Head, Tail, and Size Management
4. Printing a Linked List
5. Insertion Operations
6. Deletion Operations
7. Iterative Search
8. Recursive Search
9. Reverse a Linked List
10. Remove Nth Node From End
11. Check if Linked List is Palindrome
12. Detect Cycle in Linked List
13. Remove Cycle in Linked List
14. Time and Space Complexity
15. Project Structure
16. What to Learn Next

---

# 1. Introduction to Linked Lists

A **Linked List** is a linear data structure where elements are stored in nodes. Each node contains:

- Data
- Reference to the next node

Unlike arrays, linked lists do not require contiguous memory allocation.

### Advantages

- Dynamic size
- Efficient insertion and deletion
- No shifting of elements

### Disadvantages

- Extra memory for pointers
- Slower random access compared to arrays

---

# 2. Node Structure

Each node contains two parts:

- Data
- Reference to the next node

```java
class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
```

This structure forms the basic building block of a linked list.

---

# 3. Head, Tail, and Size Management

A linked list commonly maintains:

```java
Node head;
Node tail;
int size;
```

### Purpose

| Variable | Role                   |
| -------- | ---------------------- |
| head     | first node of the list |
| tail     | last node of the list  |
| size     | number of nodes        |

Maintaining a **tail pointer** allows O(1) insertion at the end.

---

# 4. Printing a Linked List

Traversal is required to print all elements.

```java
void printLinkedList(){
    Node temp = head;

    while(temp != null){
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }

    System.out.println("null");
}
```

### Time Complexity

```
O(n)
```

---

# 5. Insertion Operations

## Add First

Adds a node at the beginning.

```java
void addFirst(int data){

    Node newNode = new Node(data);

    if(head == null){
        head = tail = newNode;
        return;
    }

    newNode.next = head;
    head = newNode;
}
```

### Complexity

```
Time: O(1)
Space: O(1)
```

---

## Add Last

Insert node at the end.

```java
void addLast(int data){

    Node newNode = new Node(data);

    if(head == null){
        head = tail = newNode;
        return;
    }

    tail.next = newNode;
    tail = newNode;
}
```

### Complexity

```
Time: O(1)
```

---

## Add in the Middle

Insert node at a specific index.

```java
void addMiddle(int idx, int data){

    if(idx == 0){
        addFirst(data);
        return;
    }

    Node newNode = new Node(data);
    Node temp = head;

    for(int i = 0; i < idx-1; i++){
        temp = temp.next;
    }

    newNode.next = temp.next;
    temp.next = newNode;
}
```

### Complexity

```
Time: O(n)
```

---

# 6. Deletion Operations

## Remove First

```java
int removeFirst(){

    if(head == null){
        return -1;
    }

    int val = head.data;
    head = head.next;

    return val;
}
```

### Complexity

```
O(1)
```

---

## Remove Last

```java
int removeLast(){

    if(head == null) return -1;

    Node prev = head;

    while(prev.next.next != null){
        prev = prev.next;
    }

    int val = prev.next.data;
    prev.next = null;
    tail = prev;

    return val;
}
```

### Complexity

```
O(n)
```

---

# 7. Iterative Search

Search for an element using iteration.

```java
int search(int key){

    Node temp = head;
    int index = 0;

    while(temp != null){

        if(temp.data == key){
            return index;
        }

        temp = temp.next;
        index++;
    }

    return -1;
}
```

### Complexity

```
Time: O(n)
```

---

# 8. Recursive Search

Recursive approach to search.

```java
int helper(Node head, int key){

    if(head == null)
        return -1;

    if(head.data == key)
        return 0;

    int idx = helper(head.next, key);

    if(idx == -1)
        return -1;

    return idx + 1;
}
```

### Complexity

```
Time: O(n)
Space: O(n)
```

---

# 9. Reverse a Linked List

Uses three-pointer technique.

```java
void reverse(){

    Node prev = null;
    Node curr = head;
    Node next;

    while(curr != null){

        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    head = prev;
}
```

### Complexity

```
Time: O(n)
Space: O(1)
```

---

# 10. Remove Nth Node From End

Steps:

1. Calculate size
2. Find `(size - n)`
3. Remove node

```java
void deleteNthFromEnd(int n){

    int size = 0;
    Node temp = head;

    while(temp != null){
        temp = temp.next;
        size++;
    }

    int indexToFind = size - n;
    Node prev = head;

    for(int i=1;i<indexToFind;i++){
        prev = prev.next;
    }

    prev.next = prev.next.next;
}
```

---

# 11. Check if Linked List is Palindrome

Steps:

1. Find middle
2. Reverse second half
3. Compare halves

```java
boolean checkPalindrome(){

    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }

    Node prev = null;
    Node curr = slow;

    while(curr != null){
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    Node left = head;
    Node right = prev;

    while(right != null){
        if(left.data != right.data)
            return false;

        left = left.next;
        right = right.next;
    }

    return true;
}
```

---

# 12. Detect Cycle in Linked List

Uses **Floyd’s Cycle Detection Algorithm**.

```java
boolean isCycle(){

    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){

        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast)
            return true;
    }

    return false;
}
```

---

# 13. Remove Cycle

After detecting a cycle, find the start node and break it.

```java
void removeCycle(){

    Node slow = head;
    Node fast = head;

    boolean cycle = false;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast){
            cycle = true;
            break;
        }
    }

    if(!cycle) return;

    slow = head;
    Node prev = null;

    while(slow != fast){
        prev = fast;
        slow = slow.next;
        fast = fast.next;
    }

    prev.next = null;
}
```

---

# 14. Time Complexity Summary

| Operation       | Time Complexity |
| --------------- | --------------- |
| Insert First    | O(1)            |
| Insert Last     | O(1)            |
| Insert Middle   | O(n)            |
| Delete First    | O(1)            |
| Delete Last     | O(n)            |
| Search          | O(n)            |
| Reverse         | O(n)            |
| Palindrome      | O(n)            |
| Cycle Detection | O(n)            |

---

# 15. Project Structure

```
LinkedListDSA
│
├── LinkedList.java
├── IterativeSearch.java
├── RecursiveSearchLL.java
├── ReverseLL.java
├── RemoveNthNodeFromEnd.java
├── PalindromeLinkedList.java
├── CycleLinkedList.java
└── CycleLinkedList2.java
```

---

# 16. What to Learn Next

After mastering basic linked lists, the following advanced topics are recommended:

### 1. Merge Two Sorted Linked Lists

Combine two sorted lists into a single sorted list.

### 2. Merge Sort on Linked List

Sorting linked lists using divide-and-conquer.

### 3. Zig-Zag Linked List

Rearrange list as:

```
L0 → Ln → L1 → Ln-1 → L2 → Ln-2
```

### 4. Detect Intersection of Two Linked Lists

Find the node where two lists intersect.

### 5. Doubly Linked List

Each node contains:

```
prev pointer
next pointer
```

### 6. Circular Linked List

The last node points back to the head.

### 7. Flatten Multilevel Linked List

Convert nested lists into a single list.

### 8. LRU Cache Implementation

Uses:

```
HashMap + Doubly Linked List
```

### 9. Reverse Linked List in K Groups

Reverse nodes in groups of size k.

### 10. Clone Linked List with Random Pointer

Copy complex linked list structures.

### 11. Add Two Numbers Represented by Linked Lists

Used in many interview questions.

### 12. Rotate Linked List

Shift nodes by k positions.

### 13. Partition Linked List

Split nodes based on pivot value.

### 14. Remove Duplicates

From sorted or unsorted linked lists.

### 15. Middle of Linked List

Two-pointer technique.

### 16. Linked List Cycle II

Find the **exact node where cycle begins**.

---

# Conclusion

This project demonstrates a complete understanding of **Linked List Data Structures and Algorithms in Java**, covering both fundamental operations and advanced problems.

The implementations provide a solid foundation for:

- Data Structure learning
- Coding interview preparation
- Algorithmic problem solving

---

**Author**

Satinder Singh
Data Structures and Algorithms Practice Repository
