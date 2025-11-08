// Inheritance in Java — All Types Demonstrated

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("\n===== Single Inheritance =====");
        Fish f1 = new Fish();
        f1.eat();      // inherited from Animal
        f1.swim();     // from Fish

        System.out.println("\n===== Multilevel Inheritance =====");
        Shark s1 = new Shark();
        s1.eat();      // from Animal
        s1.swim();     // from Fish
        s1.hunt();     // from Shark

        System.out.println("\n===== Hierarchical Inheritance =====");
        Bird b1 = new Bird();
        b1.eat();      // from Animal
        b1.fly();      // from Bird

        Mammal m1 = new Mammal();
        m1.eat();      // from Animal
        m1.walk();     // from Mammal

        System.out.println("\n===== Multiple Inheritance (via Interfaces) =====");
        Dolphin d1 = new Dolphin();
        d1.swim();         // from Fish
        d1.play();         // from Playful
        d1.makeSound();    // from Intelligent
    }
}

// ===============================================================
// 🧱 Base Class (Parent)
class Animal {
    String color;

    void eat() {
        System.out.println("Eating...");
    }

    void breathe() {
        System.out.println("Breathing...");
    }
}

// ===============================================================
// 🐠 Single Inheritance → Fish inherits from Animal
class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swimming...");
    }
}

// ===============================================================
// 🦈 Multilevel Inheritance → Shark inherits from Fish → Animal
class Shark extends Fish {
    void hunt() {
        System.out.println("Shark is hunting...");
    }
}

// ===============================================================
// 🐦 Hierarchical Inheritance → Multiple classes share one parent (Animal)
class Bird extends Animal {
    void fly() {
        System.out.println("Flying...");
    }
}

class Mammal extends Animal {
    void walk() {
        System.out.println("Walking...");
    }
}

// ===============================================================
// 🧬 Multiple Inheritance via Interfaces
interface Playful {
    void play();
}

interface Intelligent {
    void makeSound();
}

// Dolphin inherits from Fish (class) and implements multiple interfaces
class Dolphin extends Fish implements Playful, Intelligent {
    public void play() {
        System.out.println("Dolphin is playing...");
    }

    public void makeSound() {
        System.out.println("Dolphin is communicating with clicks...");
    }
}
