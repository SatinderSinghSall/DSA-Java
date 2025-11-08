// Getters & Setters:

public class GettersAndSetters {
    public static void main(String[] args) {
        System.out.println("Topic: Getters & Setters:");

        Pen2 p1 = new Pen2();

        p1.setColor("Yellow");
        p1.setTip(5);
        System.out.println("Pen Color: " + p1.getColor());
        System.out.println("Pen Tip: " + p1.getTip());
    }
}

class Pen2 {
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
}
