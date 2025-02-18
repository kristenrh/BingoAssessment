import java.io.File;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            File file = new File("BingoCards.txt");
            List<BingoCard> cards = BingoCard.readFromFile(file);
            
            for (BingoCard card : cards) {
                System.out.println("Created BingoCard with name: " + card.getName());
                card.printCard();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
