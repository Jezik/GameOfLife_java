import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        Universe universe = new Universe(size);
        for (int i = 0; i < 10; i++) {
            System.out.println("Generation #" + (i+1));
            System.out.println("Alive: " + universe.getNumberOfAliveCells());
            System.out.print(universe.toString());
            Thread.sleep(1000);
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            }
            catch (IOException | InterruptedException e) {}
            universe.setUniverseMatrix(Utility.createNextGeneration(universe.getUniverseMatrix()));
            universe.setNumberOfAliveCells(Utility.numberOfAliveCells);
        }
    }
}
