import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int seed = scanner.nextInt();
        Random random = new Random(seed);

        boolean[][] universeMatrix = new boolean[size][size];
        // Fill in the Universe matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universeMatrix[i][j] = random.nextBoolean();
            }
        }

        // Print the current Universe
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(universeMatrix[i][j] ? 'O' : ' ');
            }
            System.out.print('\n');
        }
    }
}
