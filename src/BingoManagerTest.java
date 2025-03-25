import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class BingoManagerTest {
    @Test
    public void testRowPatterns() {
        BingoManager bingoManager = new BingoManager();
        //Add row patterns
        for (int i = 0; i < 5; i++) {
            boolean[][] rowPattern = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                rowPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(rowPattern));
        }

        //BM1: 1st row fully marked
        int[][] numbers1 = {
            {-1, -1, -1, -1, -1},
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };
        BingoCard card1 = new BingoCard("Test Card 1", numbers1);
        assertEquals(1, bingoManager.countBingos(card1));
    }
}