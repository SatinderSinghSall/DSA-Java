package Practice;

public class Average {
    public static void CalculateAverage(float num1, float num2, float num3) {
        float sum = num1 + num2 + num3;
        float avg = sum / 3.0f;
        System.out.println(avg);
    }

    public static void main(String[] args) {
        CalculateAverage(15.0f, 25.0f, 35.0f);
    }
}
