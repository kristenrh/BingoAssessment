import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class App {
    public static List<Integer> calls = new ArrayList<>(); // List that stores previous calls

    // Main method to start the Bingo game
    public static void main(String[] args) {
        // Retrieving cards from file
        File file = new File("BingoCards.txt");
        List<BingoCard> cards = new ArrayList<>();
        try {
            cards = BingoCard.readFromFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (BingoCard card : cards) {
            card.printCard();
            System.out.println();
        }

        // Game selection
        Scanner userScanner = new Scanner(System.in);
        System.out.println("Please select your game mode(manual/random): ");
        String mode = userScanner.nextLine();
        if (mode.equals("random")) {
            randomGame();
            calls.clear();
        } else {
            System.out.println("Select your card(1-9, excluding 6): ");
            BingoCard manualCard = cards.get(userScanner.nextInt() - 1);
            manualGame(manualCard);
        }

        userScanner.close();
    }

    // Method to play the game in random mode
    public static void randomGame() {
        List<BingoCard> randomCards = new ArrayList<>();
        Scanner randomScanner = new Scanner(System.in);
        int randomNumber;
        Random random = new Random();

        System.out.println("How many cards would you like to play with?(1-8): ");
        int num = randomScanner.nextInt();
        randomScanner.nextLine();
        for (int i = 0; i < num; i++) {
            randomNumber = random.nextInt(7) + 1; // generates a number between 1 and 8
            BingoCard card = BingoCard.bingoCards.get(randomNumber);
            randomCards.add(card);
        }
        System.out.println("Here are your cards for this game:");
        for (BingoCard card : randomCards) {
            card.printCard();
        }
        String win = "no";
        while (win.equals("no")) {
            int crossOffNum = call();
            for (BingoCard card : randomCards) {
                card.crossOff(crossOffNum);
            }
            for (BingoCard card : randomCards) {
                card.printCard();
            }
            System.out.println("Do you have a BINGO?(yes/no)");
            win = randomScanner.nextLine();
            if (win.equals("yes")) {
                for (BingoCard card : randomCards) {
                    if (card.evaluate() == true) {
                        System.out.println("Congratulations! You won BINGO!");
                        System.exit(0);
                    } else {
                        System.out.println("Sorry, you do not have BINGO. You are losing a card from your pile.");
                        randomCards.remove(0);
                        win = "no";
                        if (randomCards.isEmpty() == true) {
                            System.out.println("Sorry, you're all out of cards. You lost BINGO.");
                            System.exit(0);
                        }
                    }
                }
            }
        }
        randomScanner.close();
    }

    // Method to play the game in manual mode
    public static void manualGame(BingoCard card) {
        String win = "no";
        Scanner manualScanner = new Scanner(System.in);

        while (win.equals("no")) {
            System.out.println("What is your call?(ex. B6): ");
            String call = manualScanner.nextLine();
            card.printCard();
            card.crossOff(Integer.parseInt(call.substring(1)));
            System.out.println("Do you have a BINGO?(yes/no)");
            win = manualScanner.nextLine();
            if (win.equals("yes")) {
                if (card.evaluate() == true) {
                    System.out.println("Congratulations! You won BINGO!");
                    System.exit(0);
                } else {
                    System.out.println("Sorry, your card is not a winner. You lost BINGO.");
                    System.exit(0);
                }
            }
        }
        manualScanner.close();
    }

    // Method to call a random number for the Bingo game
    public static int call() {
        Random num = new Random();
        int randomNumber = num.nextInt(74) + 1; // generates a number between 1 and 75
        while (calls.contains(randomNumber)) {
            randomNumber = num.nextInt(74) + 1; // generates a number between 1 and 75
        }
        calls.add(randomNumber);

        if (randomNumber < 16) {
            System.out.println("You pulled B" + randomNumber);
        } else if (randomNumber < 30) {
            System.out.println("You pulled I" + randomNumber);
        } else if (randomNumber < 46) {
            System.out.println("You pulled N" + randomNumber);
        } else if (randomNumber < 61) {
            System.out.println("You pulled G" + randomNumber);
        } else {
            System.out.println("You pulled O" + randomNumber);
        }
        return randomNumber;
    }
}
