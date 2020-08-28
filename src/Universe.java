import java.util.Random;
import java.lang.StringBuilder;

public class Universe {
    private boolean[][] universeMatrix;
    private final int sizeOfUniverse;
    private int numberOfAliveCells = 0;

    Universe(int sizeOfUniverse) {
        Random random = new Random();
        this.sizeOfUniverse = sizeOfUniverse;
        this.universeMatrix = new boolean[sizeOfUniverse][sizeOfUniverse];
        for (int i = 0; i < sizeOfUniverse; i++) {
            for (int j = 0; j < sizeOfUniverse; j++) {
                universeMatrix[i][j] = random.nextBoolean();
                if (universeMatrix[i][j]) {
                    numberOfAliveCells++;
                }
            }
        }
    }

    public boolean[][] getUniverseMatrix() {
        return universeMatrix;
    }

    public void setUniverseMatrix(boolean[][] matrix) {
        universeMatrix = matrix;
    }

    public int getNumberOfAliveCells() {
        return numberOfAliveCells;
    }

    public void setNumberOfAliveCells(int number) {
        this.numberOfAliveCells = number;
    }

    @Override
    public String toString() {
        StringBuilder universeString = new StringBuilder();
        for (int i = 0; i < sizeOfUniverse; i++) {
            for (int j = 0; j < sizeOfUniverse; j++) {
                universeString.append(universeMatrix[i][j] ? 'O' : ' ');
            }
            universeString.append("\n");
        }

        return universeString.toString();
    }
}
