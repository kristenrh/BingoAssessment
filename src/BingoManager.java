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

}