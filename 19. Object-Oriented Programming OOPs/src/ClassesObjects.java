// Classes and Objects in Java:

public class ClassesObjects {
    public static void main(String[] args) {
        System.out.println("Classes and Objects:");
        Pen p1 = new Pen();
        p1.setColor("Blue");
        p1.setTip(5);
        System.out.println("Pen Properties: " + p1.color + " " + p1.tip);
        p1.color = "Yellow";
        p1.tip = 10;
        System.out.println("Pen Properties: " + p1.color + " " + p1.tip);
    }
}

class Pen {
    String color;
    int tip;

    public void setColor(String newColor) {
        color = newColor;
    }

    public void setTip(int newTip) {
        tip = newTip;
    }
}

class Student {
    String name;
    int age;
    float percentage;

    public void calculatePercentage(int marks1, int marks2, int marks3) {
        percentage = (marks1 + marks2 + marks3) / 3;
    }
}

class BankAccount {

}
