// Find Shortest Path:

public class ShortestPath {
    public static float ShortestPath_Algorithm(String stringPath) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < stringPath.length(); i ++) {
            char direction = stringPath.charAt(i);

            if(direction == 'S') { // south
                y = y - 1;
            } else if (direction == 'N') { // north
                y = y + 1;
            } else if (direction == 'E') { // east
                x = x + 1;
            } else { // west
                x = x - 1;
            }
        }

        int X2 = x * x;
        int Y2 = y * y;
        return (float)Math.sqrt(X2 + Y2);
    }

    public static void main(String[] args) {
        String stringPath = "WNEENESENNN";
        System.out.println(ShortestPath_Algorithm(stringPath));
    }
}
