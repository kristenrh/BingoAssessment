import org.junit.Test;
import static org.junit.Assert.*;

public class PatternTest {

    @Test
    public void testRowPattern() {
        //P1: 1st row fully marked
        boolean[][] rowPattern = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            rowPattern[0][i] = true;
        }
        Pattern pattern = new Pattern(rowPattern);

        int[][] numbers = {
            {-1, -1, -1, -1, -1},
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };
        BingoCard card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.checkRow(card));
    }
}