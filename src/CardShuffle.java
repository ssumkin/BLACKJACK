import java.util.Random;

public class CardShuffle {
    Random rand = new Random();
    
    char[][] card = {
        { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K' },
        { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K' },
        { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K' },
        { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K' }
    };
    

    int index1 = rand.nextInt(4);
    int index2 = rand.nextInt(13);

    public int shuffle() {

        
        
        int a = card[this.index1][this.index2];


        return a;
    }

}
