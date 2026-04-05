// Hashing: Find Itinerary from Tickets using HashMap.

import java.util.HashMap;
import java.util.HashSet;

public class FindItinerary {
    public static void main(String[] args) {
        System.out.println("Hashing: Find Itinerary from Tickets using HashMap.");

        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        // Step 1: Find starting point
        HashSet<String> destinations = new HashSet<>();

        for (String to : tickets.values()) {
            destinations.add(to);
        }

        String start = "";

        for (String from : tickets.keySet()) {
            if (!destinations.contains(from)) {
                start = from;
                break;
            }
        }

        // Step 2: Print itinerary
        System.out.print("Itinerary: ");
        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start);
    }
}
