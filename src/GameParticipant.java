public abstract class GameParticipant { // 게임 참가자
    int total;
    char[] deck;

    abstract int sumOfCards();
}
 

class Dealer extends GameParticipant {
    int sumOfCards() { 
        int deckTotal = 0;
   
        for(int i = 0; i < deck.length; i++) {
           switch(deck[i]) {
              case 'A': {
                 deckTotal += 11;
              }
              case '2': {
                 deckTotal += 2;
              }
              case '3': {
                 deckTotal += 3;
              }
              case '4': {
                 deckTotal += 4;
              }
              case '5': {
                 deckTotal += 5;
              }
              case '6': {
                 deckTotal += 6;
              }
              case '7': {
                 deckTotal += 7;
              }
              case '8': {
                 deckTotal += 8;
              }
              case '9': {
                 deckTotal += 9;
              }
              case 'J':
              case 'Q':
              case 'K': {
                 deckTotal += 10;
              } 
           }
        }
  
        for(int i = 0; i < deck.length; i++) {
           if(deck[i] == 'A') {
              deckTotal = (deckTotal > 21 ? deckTotal-10 : deckTotal);
           }
        } 
  
   
        return deckTotal;
     }
}

class Player extends GameParticipant {
    Double chips;
    Double pairbatChips;
    Double insuranceChips;



    Player() {}
    Player(Double chips) {
        this.chips = chips;
    }

    public void nowDeck() {
        for (char c : deck) { 
            if(c != 0) {
                System.out.print(c+" "); 
            }
        }
        System.out.println();
    }
    
    
    int sumOfCards() {

        int deckTotal = 0;
   
        for(int i = 0; i < deck.length; i++) {
           switch(deck[i]) {
              case 'A': {
                 deckTotal += 11;
                 break;
              }
              case '2': {
                 deckTotal += 2;
                 break;
              }
              case '3': {
                 deckTotal += 3;
                 break;
              }
              case '4': {
                 deckTotal += 4;
                 break;
              }
              case '5': {
                 deckTotal += 5;
                 break;
              }
              case '6': {
                 deckTotal += 6;
                 break;
              }
              case '7': {
                 deckTotal += 7;
                 break;
              }
              case '8': {
                 deckTotal += 8;
                 break;
              }
              case '9': {
                 deckTotal += 9;
                 break;
              }
              case 'J':
              case 'Q':
              case 'K': {
                 deckTotal += 10;
                 break;
              }  
           }
        }
  
        for(int i = 0; i < deck.length; i++) {
           if(deck[i] == 'A') {
              deckTotal = (deckTotal > 21 ? deckTotal-10 : deckTotal);
           }
        } 
   
        return deckTotal;
     }


}