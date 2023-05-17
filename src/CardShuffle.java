import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CardShuffle {
    Random rand = new Random();
    
 
    // card 덱 넣을 List 배열 생성
    List<Character>[] cardList = new List[4]; 
    
    CardShuffle() { // 생성자에 A ~ K 카드를 넣는 반복문 써서 객체 생성시 바로 덱 구성 되도록 설정
        for(int i = 0; i < cardList.length; i++) {
            cardList[i] = new ArrayList<>(Arrays.asList(
               'A', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K'));
        }
    }

    public char drawCard() {

        int index1 = rand.nextInt(cardList.length);
        int index2 = rand.nextInt(cardList[index1].size());

        char card = cardList[index1].get(index2);

        cardList[index1].remove(index2);

        return card;
    }

}
