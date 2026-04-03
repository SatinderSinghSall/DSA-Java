// Heap Data Structure: Nearby Cars Problems Solution.

import java.util.*;

// Class representing a car (point)
class Car {
    int x, y;
    int dist; // distance from origin (x^2 + y^2)

    Car(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = x * x + y * y; // no sqrt needed
    }
}

public class NearestKCars {

    public static void main(String[] args) {

        int[][] points = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };

        int k = 2;

        List<Car> result = nearestCars(points, k);

        // Print result
        System.out.println("Nearest K Cars:");
        for (Car c : result) {
            System.out.println("(" + c.x + ", " + c.y + ")");
        }
    }

    public static List<Car> nearestCars(int[][] points, int k) {

        // Max Heap → largest distance at top
        PriorityQueue<Car> pq = new PriorityQueue<>(
                (a, b) -> b.dist - a.dist
        );

        // Step 1: Process all points
        for (int[] p : points) {

            Car car = new Car(p[0], p[1]);

            // Add to heap
            pq.add(car);

            // Step 2: Maintain only K elements
            if (pq.size() > k) {
                pq.poll(); // remove farthest car
            }
        }

        // Step 3: Extract results
        List<Car> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}
