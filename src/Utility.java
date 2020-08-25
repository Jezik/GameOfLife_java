/** Service class for creation of the next Universe generation
 *  createNextGeneration(boolean[][] matrix) - takes the state of Universe and return new generation
 *  getNeighbours(boolean[][] matrix, int i, int j) - returns boolean[] with adjacent cells
 *  isAliveCell(boolean[] neighbours, boolean stateInPreviousGeneration) - determines whether or not the cell will be alive
 *                                                                                          in the next generation
 */

public class Utility {

    public static boolean[][] createNextGeneration(boolean[][] matrix) {
        boolean[][] nextGenerationMatrix = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nextGenerationMatrix[i][j] = isAliveCell(getNeighbours(matrix, i, j), matrix[i][j]);
            }
        }

        return nextGenerationMatrix;
    }

    private static boolean[] getNeighbours(boolean[][] matrix, int i, int j) {
        int iLessIndex = i - 1 < 0 ? matrix.length - 1 : i - 1;
        int iBiggerIndex = i + 1 == matrix.length ? 0 : i + 1;
        int jLessIndex = j - 1 < 0 ? matrix[0].length - 1 : j - 1;
        int jBiggerIndex = j + 1 == matrix[0].length ? 0 : j + 1;

        return new boolean[]{
                matrix[iLessIndex][j],
                matrix[iLessIndex][jBiggerIndex],
                matrix[i][jBiggerIndex],
                matrix[iBiggerIndex][jBiggerIndex],
                matrix[iBiggerIndex][j],
                matrix[iBiggerIndex][jLessIndex],
                matrix[i][jLessIndex],
                matrix[iLessIndex][jLessIndex]
        };
    }

    private static boolean isAliveCell(boolean[] neighbours, boolean stateInPreviousGeneration) {
        int counter = 0;
        for (boolean neighbour : neighbours) {
            if (neighbour) {
                counter++;
            }
        }

        boolean isAlive = false;
        if (stateInPreviousGeneration) {
            if (counter > 1 && counter < 4) {
                isAlive = true;
            }
        } else {
            if (counter == 3) {
                isAlive = true;
            }
        }

        return isAlive;
    }
}
