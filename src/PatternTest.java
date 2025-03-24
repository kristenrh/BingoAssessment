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

        //P2: 3rd row fully marked
        rowPattern = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            rowPattern[2][i] = true;
        }
        pattern = new Pattern(rowPattern);
        numbers = new int[][]{
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {-1, -1, -1, -1, -1},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };
        card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.checkRow(card));

        //P3: Last row fully marked
        rowPattern = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            rowPattern[4][i] = true;
        }
        pattern = new Pattern(rowPattern);
        numbers = new int[][]{
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {-1, -1, -1, -1, -1}
        };
        card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.checkRow(card));

        //P4: 1st row fully marked except last column
        numbers = new int[][]{
            {-1, -1, -1, -1, 5},
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };
        card = new BingoCard("Test Card", numbers);
        assertFalse(pattern.checkRow(card));
    }
}