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
        if (pattern != null) { //check for pattern
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (pattern[i][j] && numbers[i][j] != -1) {
                        return false;
                    }
                }
            }
            return true;
        } else if (customPattern != null) { //check for custom pattern
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

}