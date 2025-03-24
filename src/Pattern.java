import java.util.List;

public class Pattern {
    private boolean[][] pattern;
    private List<int[]> customPattern;

    /**
     * Constructor to initialize the pattern.
     * @param pattern The 2D array containing the pattern.
     */
    public Pattern(boolean[][] pattern) {
        this.pattern = pattern;
    }

    /**
     * Constructor to initialize the custom pattern.
     * @param customPattern The list of coordinates within the custom pattern.
     */
    public Pattern(List<int[]> customPattern) {
        this.customPattern = customPattern;
    }

    /**
     * Getter for the pattern.
     * @return The 2D array representing the pattern.
     */
    public boolean[][] getPattern() {
        return pattern;
    }

    /**
     * Method to check if a card matches the pattern.
     * @param card The BingoCard to check.
     * @return True if the card matches the pattern, false otherwise.
     */
    public boolean matches(BingoCard card) {
        int[][] numbers = card.getNumbers();
        if (pattern != null) { // check for pattern
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (pattern[i][j] && numbers[i][j] != -1) {
                        return false;
                    }
                }
            }
            return true;
        } else if (customPattern != null) { // check for custom pattern
            for (int[] coordinate : customPattern) {
                int x = coordinate[0];
                int y = coordinate[1];
                if (numbers[x][y] != -1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Method to check if a card has a fully marked row.
     * @param card The BingoCard to check.
     * @return True if the card has a fully marked row, false otherwise.
     */
    public boolean checkRow(BingoCard card) {
        int[][] numbers = card.getNumbers();
        for (int i = 0; i < 5; i++) {
            boolean rowBingo = true;
            for (int j = 0; j < 5; j++) {
                if (numbers[i][j] != -1) {
                    rowBingo = false;
                    break;
                }
            }
            if (rowBingo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check if a card has a fully marked column.
     * @param card The BingoCard to check.
     * @return True if the card has a fully marked column, false otherwise.
     */
    public static boolean checkColumn(BingoCard card) {
        int[][] numbers = card.getNumbers();
        for (int j = 0; j < 5; j++) {
            boolean columnBingo = true;
            for (int i = 0; i < 5; i++) {
                if (numbers[i][j] != -1) {
                    columnBingo = false;
                    break;
                }
            }
            if (columnBingo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check if a card has a fully marked diagonal.
     * @param card The BingoCard to check.
     * @return True if the card has a fully marked diagonal, false otherwise.
     */
    public static boolean checkDiagonal(BingoCard card) {
        int[][] numbers = card.getNumbers();
        boolean diagonalBingo1 = true;
        boolean diagonalBingo2 = true;
        for (int i = 0; i < 5; i++) {
            if (numbers[i][i] != -1) {
                diagonalBingo1 = false;
            }
            if (numbers[i][4 - i] != -1) {
                diagonalBingo2 = false;
            }
        }
        return diagonalBingo1 || diagonalBingo2;
    }
}