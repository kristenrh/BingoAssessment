import java.util.ArrayList;
import java.util.List;

public class BingoManager {
    private List<Pattern> patterns;

    public BingoManager() {
        this.patterns = new ArrayList<>();
    }

    /**
     * Method to add a pattern for valid bingos.
     * @param pattern The pattern to add.
     */
    public void addPattern(Pattern pattern) {
        patterns.add(pattern);
    }

    /**
     * Method to count the number of bingos found on a card.
     * @param card The BingoCard to check.
     * @return The number of bingos found.
     */
    public int countBingos(BingoCard card) {
        int bingoCount = 0;
        for (Pattern pattern : patterns) {
            if (pattern.matches(card)) {
                bingoCount++;
            }
        }
        return bingoCount;
    }
}