# 🧱 Object-Oriented Programming (OOP) in Java — Complete Guide

A comprehensive guide to **Object-Oriented Programming (OOP) in Java**, covering:

- Core OOP principles
- Theory with real-world analogies
- Keywords and concepts
- Code examples
- Interview-focused explanations

Perfect for **Java beginners, DSA learners, and interview preparation**.

---

## 📚 Table of Contents

- [Introduction](#introduction)
- [What is OOP?](#what-is-oop)
- [Why OOP is Important](#why-oop-is-important)
- [Class and Object](#class-and-object)
- [Four Pillars of OOP](#four-pillars-of-oop)
  - [Encapsulation](#1-encapsulation)
  - [Abstraction](#2-abstraction)
  - [Inheritance](#3-inheritance)
  - [Polymorphism](#4-polymorphism)
- [Constructors](#constructors)
- [`this` Keyword](#this-keyword)
- [`static` Keyword](#static-keyword)
- [Interfaces vs Abstract Classes](#interfaces-vs-abstract-classes)
- [OOP in Real World](#oop-in-real-world)
- [Best Practices](#best-practices)
- [Common Mistakes](#common-mistakes)
- [Conclusion](#conclusion)

---

## 📖 Introduction

Object-Oriented Programming (OOP) is a programming paradigm based on **objects** rather than functions.

Java is a **pure object-oriented language** (almost), and OOP is the backbone of:

- Enterprise applications
- Android development
- Backend systems
- Large-scale software

---

## ❓ What is OOP?

**OOP** is a way of designing programs using:

- **Classes** (blueprints)
- **Objects** (real instances)

### Real-world analogy

| Real World       | OOP       |
| ---------------- | --------- |
| Car              | Class     |
| Your car         | Object    |
| Color, speed     | Variables |
| Drive(), brake() | Methods   |

---

## 🤔 Why OOP is Important?

✔ Improves code reusability  
✔ Makes code modular  
✔ Easy to maintain & extend  
✔ Models real-world problems  
✔ Essential for interviews

---

## 🧩 Class and Object

---

### 🔹 Class

A **class** is a blueprint that defines:

- Properties (variables)
- Behaviors (methods)

```java
class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("Car is driving");
    }
}
```

````

---

### 🔹 Object

An **object** is an instance of a class.

```java
public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.color = "Red";
        c1.speed = 100;
        c1.drive();
    }
}
```

---

## 🏛 Four Pillars of OOP

---

## 1️⃣ Encapsulation

### 📌 Concept

Encapsulation means **wrapping data and methods together** and **hiding internal details**.

Achieved using:

- `private` variables
- `public` getters/setters

---

### Example

```java
class BankAccount {
    private int balance;

    public void setBalance(int amount) {
        if (amount >= 0)
            balance = amount;
    }

    public int getBalance() {
        return balance;
    }
}
```

✔ Data security
✔ Controlled access

---

## 2️⃣ Abstraction

### 📌 Concept

Abstraction means **hiding implementation details** and showing only essential features.

Achieved using:

- Abstract classes
- Interfaces

---

### Abstract Class Example

```java
abstract class Vehicle {
    abstract void start();
}
```

```java
class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with kick");
    }
}
```

---

## 3️⃣ Inheritance

### 📌 Concept

Inheritance allows a class to **acquire properties and methods of another class**.

Uses keyword `extends`.

---

### Example

```java
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}
```

✔ Code reusability
✔ IS-A relationship

---

## 4️⃣ Polymorphism

### 📌 Concept

Polymorphism means **one thing, many forms**.

Types:

- Compile-time (Method Overloading)
- Runtime (Method Overriding)

---

### Method Overloading

```java
class MathUtils {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

---

### Method Overriding

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}
```

---

## 🔧 Constructors

A **constructor** initializes objects.

```java
class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }
}
```

✔ Same name as class
✔ No return type

---

## 🔁 `this` Keyword

Used to refer to the **current object**.

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}
```

---

## ⚙ `static` Keyword

Belongs to the **class**, not objects.

```java
class Counter {
    static int count = 0;

    Counter() {
        count++;
    }
}
```

✔ Shared memory
✔ Used for utility methods

---

## 🧵 Interfaces vs Abstract Classes

| Feature              | Interface           | Abstract Class      |
| -------------------- | ------------------- | ------------------- |
| Multiple inheritance | ✔                   | ❌                  |
| Constructors         | ❌                  | ✔                   |
| Variables            | public static final | Any                 |
| Methods              | abstract / default  | abstract / concrete |

---

### Interface Example

```java
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}
```

---

## 🌍 OOP in Real World

| OOP Concept   | Example            |
| ------------- | ------------------ |
| Encapsulation | ATM machine        |
| Abstraction   | Car steering       |
| Inheritance   | Employee → Manager |
| Polymorphism  | Shape → draw()     |

---

## ✅ Best Practices

✔ Follow single responsibility principle
✔ Keep variables private
✔ Prefer composition over inheritance
✔ Use interfaces for contracts
✔ Write readable and modular code

---

## ❌ Common Mistakes

❌ Making everything public
❌ Deep inheritance chains
❌ Ignoring abstraction
❌ Confusing inheritance with composition
❌ Overusing static

---

## 🏁 Conclusion

Object-Oriented Programming is the **foundation of Java development**.

> Mastering OOP helps you:

- Write scalable code
- Crack interviews
- Build real-world applications

---

⭐ If this repository helped you, **give it a star**
Happy Coding 🚀
````
