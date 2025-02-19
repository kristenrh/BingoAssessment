import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoCard {
    private String name = "";
    private int[][] numbers;
    public static List<BingoCard> bingoCards;

    // Constructor to initialize BingoCard with name and numbers
    public BingoCard(String n, int[][] num) {
        this.name = n;
        this.numbers = num;
    }

    // Static method to read Bingo cards from a file
    public static List<BingoCard> readFromFile(File file) throws Exception {
        Scanner scanner = new Scanner(file);
        List<BingoCard> cards = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            int[][] numbers = new int[5][5];
            for (int i = 0; i < 5; i++) {
                if (scanner.hasNextLine()) {
                    String[] lineNumbers = scanner.nextLine().trim().split(",");
                    for (int j = 0; j < 5; j++) {
                        numbers[i][j] = Integer.parseInt(lineNumbers[j]);
                    }
                }
            }
            cards.add(new BingoCard(name, numbers));
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Skip the empty line between cards
            }
        }

        scanner.close();
        bingoCards = cards;
        return cards;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for numbers array
    public int[][] getNumbers() {
        return numbers;
    }

    // Method to cross off a number on the Bingo card
    public void crossOff(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (num == numbers[i][j]) {
                    numbers[i][j] = -1;
                }
            }
        }
    }

    // Method to evaluate if the Bingo card has a winning combination
    public boolean evaluate() {
        boolean overall = false;
        // Check rows
        for (int i = 0; i < 5; i++) {
            boolean rowBingo = true;
            for (int j = 0; j < 5; j++) {
                if (numbers[i][j] != -1) {
                    rowBingo = false;
                }
            }
            if (rowBingo) return true;
        }

        // Check columns
        for (int j = 0; j < 5; j++) {
            boolean colBingo = true;
            for (int i = 0; i < 5; i++) {
                if (numbers[i][j] != -1) {
                    colBingo = false;
                }
            }
            if (colBingo) return true;
        }

        // Check diagonals
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

    // Method to print the Bingo card
    public void printCard() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("BingoCard Name: " + name);
        System.out.println("|\tB\t|\tI\t|\tN\t|\tG\t|\tO\t|");
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.print("|\t");
            for (int j = 0; j < 5; j++) {
                if (numbers[i][j] == -1) {
                    System.out.print("XX\t|\t");
                } else {
                    System.out.print(numbers[i][j] + "\t|\t");
                }
            }
            System.out.println();
            System.out.print("---------------------------------------------------------------------------------");
            System.out.println();
        }
    }
}
