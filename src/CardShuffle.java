import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CardShuffle {
    Random rand = new Random();
    
 
    // 
    List<Character>[] cardList = new List[4]; 
    
    CardShuffle() {
        for(int i = 0; i < cardList.length; i++) {
            cardList[i] = new ArrayList<>(Arrays.asList(
               'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K'));
        }
    }

    public int drawCard() {


        int index1 = rand.nextInt(4);
        int index2 = rand.nextInt(13);

        int a = cardList[index1].get(index2);

        cardList[index1].remove(index2);
        



        return a;
    }

}
