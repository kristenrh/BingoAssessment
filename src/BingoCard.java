import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoCard {
    private String name = "";
    private int[][] numbers;

    public BingoCard(String n, int[][] num) {
        this.name = n;
        this.numbers = num;
    }

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
        return cards;
    }

    public String getName() {
        return name;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public void printCard() {
        System.out.println("BingoCard Name: " + name);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
