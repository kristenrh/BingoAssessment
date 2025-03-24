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
}