import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int seed = scanner.nextInt();
        int steps = scanner.nextInt(); // Represents steps from the initial state of universe to output according to the task

        Universe universe = new Universe(size, seed);
        for (int i = 0; i < steps; i++) {
            universe.setUniverseMatrix(Utility.createNextGeneration(universe.getUniverseMatrix()));
        }

        System.out.print(universe.toString());
    }
}
