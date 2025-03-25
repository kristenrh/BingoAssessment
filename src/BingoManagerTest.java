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

        //BM2: 1st, 3rd, and last row fully marked
        int[][] numbers2 = {
            {-1, -1, -1, -1, -1},
            {1, 2, 3, 4, 5},
            {-1, -1, -1, -1, -1},
            {11, 12, 13, 14, 15},
            {-1, -1, -1, -1, -1}
        };
        BingoCard card2 = new BingoCard("Test Card 2", numbers2);
        assertEquals(3, bingoManager.countBingos(card2));

        //BM3: 1st, 3rd, and last row fully marked, and last column fully marked
        int[][] numbers3 = {
            {-1, -1, -1, -1, -1},
            {1, 2, 3, 4, -1},
            {-1, -1, -1, -1, -1},
            {11, 12, 13, 14, -1},
            {-1, -1, -1, -1, -1}
        };
        BingoCard card3 = new BingoCard("Test Card 3", numbers3);
        assertEquals(3, bingoManager.countBingos(card3));
    }

    @Test
    public void testRowColumnPatterns() {
        BingoManager bingoManager = new BingoManager();
        //Add row patterns
        for (int i = 0; i < 5; i++) {
            boolean[][] rowPattern = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                rowPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(rowPattern));
        }
        //Add column patterns
        for (int j = 0; j < 5; j++) {
            boolean[][] columnPattern = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                columnPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(columnPattern));
        }

        //BM4: 1st, 3rd, and last row fully marked, and last column fully marked
        int[][] numbers = {
            {-1, -1, -1, -1, -1},
            {1, 2, 3, 4, -1},
            {-1, -1, -1, -1, -1},
            {11, 12, 13, 14, -1},
            {-1, -1, -1, -1, -1}
        };
        BingoCard card = new BingoCard("Test Card 1", numbers);
        assertEquals(4, bingoManager.countBingos(card));
    }

    @Test
    public void testRowColumnnDiagonalPatterns() {
        BingoManager bingoManager = new BingoManager();
        //Add row patterns
        for (int i = 0; i < 5; i++) {
            boolean[][] rowPattern = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                rowPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(rowPattern));
        }
        //Add column patterns
        for (int j = 0; j < 5; j++) {
            boolean[][] columnPattern = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                columnPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(columnPattern));
        }
        //Add diagonal patterns
        boolean[][] diagonalPattern1 = new boolean[5][5];
        boolean[][] diagonalPattern2 = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            diagonalPattern1[i][i] = true;
            diagonalPattern2[i][4 - i] = true;
        }
        bingoManager.addPattern(new Pattern(diagonalPattern1));
        bingoManager.addPattern(new Pattern(diagonalPattern2));

        //BM5: Full card marked
        int[][] numbers = {
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
        };
        BingoCard card = new BingoCard("Test Card 2", numbers);
        assertEquals(12, bingoManager.countBingos(card));
    }

    @Test
    public void testRowColumnDiagonalCustomPatterns1() {
        BingoManager bingoManager = new BingoManager();
        //Add row patterns
        for (int i = 0; i < 5; i++) {
            boolean[][] rowPattern = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                rowPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(rowPattern));
        }
        //Add column patterns
        for (int j = 0; j < 5; j++) {
            boolean[][] columnPattern = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                columnPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(columnPattern));
        }
        //Add diagonal patterns
        boolean[][] diagonalPattern1 = new boolean[5][5];
        boolean[][] diagonalPattern2 = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            diagonalPattern1[i][i] = true;
            diagonalPattern2[i][4 - i] = true;
        }
        bingoManager.addPattern(new Pattern(diagonalPattern1));
        bingoManager.addPattern(new Pattern(diagonalPattern2));
        //Add custom patterns
        List<int[]> customPattern1 = Arrays.asList(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2}, new int[]{4, 2}
        );
        bingoManager.addPattern(new Pattern(customPattern1));
        List<int[]> customPattern2 = Arrays.asList(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{4, 0}, new int[]{4, 1}, new int[]{4, 2}, new int[]{4, 3}, new int[]{4, 4},
            new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0},
            new int[]{1, 4}, new int[]{2, 4}, new int[]{3, 4}
        );
        bingoManager.addPattern(new Pattern(customPattern2));

        //BM6: Full card marked
        int[][] numbers = {
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
        };
        BingoCard card = new BingoCard("Test Card", numbers);
        assertEquals(14, bingoManager.countBingos(card));
    }
    @Test
    public void testRowColumnDiagonalCustomPatterns2() {
        BingoManager bingoManager = new BingoManager();
        //Add row patterns
        for (int i = 0; i < 5; i++) {
            boolean[][] rowPattern = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                rowPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(rowPattern));
        }
        //Add column patterns
        for (int j = 0; j < 5; j++) {
            boolean[][] columnPattern = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                columnPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(columnPattern));
        }
        //Add diagonal patterns
        boolean[][] diagonalPattern1 = new boolean[5][5];
        boolean[][] diagonalPattern2 = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            diagonalPattern1[i][i] = true;
            diagonalPattern2[i][4 - i] = true;
        }
        bingoManager.addPattern(new Pattern(diagonalPattern1));
        bingoManager.addPattern(new Pattern(diagonalPattern2));
        //Add custom patterns
        List<int[]> customPattern1 = Arrays.asList(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2}, new int[]{4, 2}
        );
        bingoManager.addPattern(new Pattern(customPattern1));
        List<int[]> customPattern2 = Arrays.asList(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{4, 0}, new int[]{4, 1}, new int[]{4, 2}, new int[]{4, 3}, new int[]{4, 4},
            new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0},
            new int[]{1, 4}, new int[]{2, 4}, new int[]{3, 4}
        );
        bingoManager.addPattern(new Pattern(customPattern2));

        //BM7: Full card marked except for top right corner
        int[][] numbers = {
            {-1, -1, -1, -1, 5},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
        };
        BingoCard card = new BingoCard("Test Card", numbers);
        assertEquals(9, bingoManager.countBingos(card));
    }

    @Test
    public void testRowColumnDiagonalCustomPatterns3() {
        BingoManager bingoManager = new BingoManager();
        //Add row patterns
        for (int i = 0; i < 5; i++) {
            boolean[][] rowPattern = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                rowPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(rowPattern));
        }
        //Add column patterns
        for (int j = 0; j < 5; j++) {
            boolean[][] columnPattern = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                columnPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(columnPattern));
        }
        //Add diagonal patterns
        boolean[][] diagonalPattern1 = new boolean[5][5];
        boolean[][] diagonalPattern2 = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            diagonalPattern1[i][i] = true;
            diagonalPattern2[i][4 - i] = true;
        }
        bingoManager.addPattern(new Pattern(diagonalPattern1));
        bingoManager.addPattern(new Pattern(diagonalPattern2));
        //Add custom patterns
        List<int[]> customPattern1 = Arrays.asList(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2}, new int[]{4, 2}
        );
        bingoManager.addPattern(new Pattern(customPattern1));
        List<int[]> customPattern2 = Arrays.asList(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{4, 0}, new int[]{4, 1}, new int[]{4, 2}, new int[]{4, 3}, new int[]{4, 4},
            new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0},
            new int[]{1, 4}, new int[]{2, 4}, new int[]{3, 4}
        );
        bingoManager.addPattern(new Pattern(customPattern2));

        //BM8: Full card marked except for 2nd row, 2nd column
        int[][] numbers = {
            {-1, -1, -1, -1, -1},
            {-1, 2, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
        };
        BingoCard card = new BingoCard("Test Card", numbers);
        assertEquals(11, bingoManager.countBingos(card));
    }

    @Test
    public void testRowColumnDiagonalCustomPatterns4() {
        BingoManager bingoManager = new BingoManager();
        //Add row patterns
        for (int i = 0; i < 5; i++) {
            boolean[][] rowPattern = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                rowPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(rowPattern));
        }
        //Add column patterns
        for (int j = 0; j < 5; j++) {
            boolean[][] columnPattern = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                columnPattern[i][j] = true;
            }
            bingoManager.addPattern(new Pattern(columnPattern));
        }
        //Add diagonal patterns
        boolean[][] diagonalPattern1 = new boolean[5][5];
        boolean[][] diagonalPattern2 = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            diagonalPattern1[i][i] = true;
            diagonalPattern2[i][4 - i] = true;
        }
        bingoManager.addPattern(new Pattern(diagonalPattern1));
        bingoManager.addPattern(new Pattern(diagonalPattern2));
        //Add custom patterns
        List<int[]> customPattern1 = Arrays.asList(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2}, new int[]{4, 2}
        );
        bingoManager.addPattern(new Pattern(customPattern1));
        List<int[]> customPattern2 = Arrays.asList(
            new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{0, 4},
            new int[]{4, 0}, new int[]{4, 1}, new int[]{4, 2}, new int[]{4, 3}, new int[]{4, 4},
            new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0},
            new int[]{1, 4}, new int[]{2, 4}, new int[]{3, 4}
        );
        bingoManager.addPattern(new Pattern(customPattern2));

        //BM9: Full card marked except for 3rd row, 2nd column
        int[][] numbers = {
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, 2, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
        };
        BingoCard card = new BingoCard("Test Card", numbers);
        assertEquals(12, bingoManager.countBingos(card));
    }
}