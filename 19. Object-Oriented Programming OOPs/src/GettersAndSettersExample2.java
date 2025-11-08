// Getters and Setters Example 2:

public class GettersAndSettersExample2 {
    public static void main(String[] args) {
        Person p1 = new Person();

        // Set values using setters
        p1.setName("Satinder Singh");
        p1.setAge(22);

        // Get values using getters
        System.out.println("Name: " + p1.getName());
        System.out.println("Age: " + p1.getAge());
    }
}

class Person {
    private String name;  // private field
    private int age;      // private field

    // Setter method → sets the value
    public void setName(String newName) {
        name = newName;
    }

    // Getter method → returns the value
    public String getName() {
        return name;
    }

    public void setAge(int newAge) {
        if (newAge >= 0) { // validation check
            age = newAge;
        } else {
            System.out.println("Invalid age!");
        }
    }

    public int getAge() {
        return age;
    }
}

