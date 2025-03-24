import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

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

    @Test
    public void testColumnPattern() {
        //P5: 1st column fully marked
        boolean[][] columnPattern = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            columnPattern[i][0] = true;
        }
        Pattern pattern = new Pattern(columnPattern);
        int[][] numbers = {
            {-1, 1, 2, 3, 4},
            {-1, 5, 6, 7, 8},
            {-1, 9, 10, 11, 12},
            {-1, 13, 14, 15, 16},
            {-1, 17, 18, 19, 20}
        };
        BingoCard card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.checkColumn(card));

        //P6: 4th column fully marked
        for (int i = 0; i < 5; i++) {
            columnPattern[i][0] = false;
            columnPattern[i][3] = true;
        }
        pattern = new Pattern(columnPattern);
        numbers = new int[][]{
            {1, 2, 3, -1, 5},
            {6, 7, 8, -1, 10},
            {11, 12, 13, -1, 15},
            {16, 17, 18, -1, 20},
            {21, 22, 23, -1, 25}
        };
        card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.checkColumn(card));

        //P7: Last column fully marked
        for (int i = 0; i < 5; i++) {
            columnPattern[i][3] = false;
            columnPattern[i][4] = true;
        }
        pattern = new Pattern(columnPattern);
        numbers = new int[][]{
            {1, 2, 3, 4, -1},
            {6, 7, 8, 9, -1},
            {11, 12, 13, 14, -1},
            {16, 17, 18, 19, -1},
            {21, 22, 23, 24, -1}
        };
        card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.checkColumn(card));

        //P8: 1st row fully marked
        for (int i = 0; i < 5; i++) {
            columnPattern[i][4] = false;
            columnPattern[0][i] = true;
        }
        pattern = new Pattern(columnPattern);
        numbers = new int[][]{
            {-1, -1, -1, -1, -1},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        card = new BingoCard("Test Card", numbers);
        assertFalse(pattern.checkColumn(card));

        //P9: 2nd column fully marked except 2nd row
        for (int i = 0; i < 5; i++) {
            columnPattern[i][0] = false;
            columnPattern[i][1] = true;
        }
        pattern = new Pattern(columnPattern);
        numbers = new int[][]{
            {1, -1, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, -1, 13, 14, 15},
            {16, -1, 18, 19, 20},
            {21, -1, 23, 24, 25}
        };
        card = new BingoCard("Test Card", numbers);
        assertFalse(pattern.checkColumn(card));
    }

    @Test
    public void testDiagonalPattern() {
        //P10: Top-right to Bottom-left fully marked
        boolean[][] diagonalPattern = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            diagonalPattern[i][i] = true;
        }
        Pattern pattern = new Pattern(diagonalPattern);
        int[][] numbers = {
            {-1, 1, 2, 3, 4},
            {5, -1, 6, 7, 8},
            {9, 10, -1, 11, 12},
            {13, 14, 15, -1, 16},
            {17, 18, 19, 20, -1}
        };
        BingoCard card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.checkDiagonal(card));

        //P11: Top-left to Bottom-right fully marked
        numbers = new int[][]{
            {-1, 1, 2, 3, 4},
            {5, -1, 6, 7, 8},
            {9, 10, -1, 11, 12},
            {13, 14, 15, -1, 16},
            {17, 18, 19, 20, -1}
        };
        card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.checkDiagonal(card));

        //P12: 2nd row fully marked
        numbers = new int[][]{
            {1, 2, 3, 4, 5},
            {-1, -1, -1, -1, -1},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };
        card = new BingoCard("Test Card", numbers);
        assertFalse(pattern.checkDiagonal(card));
    }

    @Test
    public void testCustomPattern() {
        //P13: Custom Pattern of Top row & Middle Column
        List<int[]> customPattern = List.of(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2}, new int[]{4, 2}
        ); //list.of holds coordinates
        Pattern pattern = new Pattern(customPattern);
        int[][] numbers = {
            {-1, -1, -1, -1, -1},
            {1, 2, -1, 4, 5},
            {6, 7, -1, 9, 10},
            {11, 12, -1, 14, 15},
            {16, 17, -1, 19, 20}
        };
        BingoCard card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.matches(card));

        //P14: Entire card fully marked
        numbers = new int[][]{
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
        };
        card = new BingoCard("Test Card", numbers);
        assertTrue(pattern.matches(card));

        //P15: Top row and middle column fully marked except for the middle space
        numbers = new int[][]{
            {-1, -1, -1, -1, -1},
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };
        card = new BingoCard("Test Card", numbers);
        assertFalse(pattern.matches(card));
    }
}