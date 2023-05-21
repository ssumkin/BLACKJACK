public abstract class GameParticipant { // 게임 참가자
    int total;
    char[] deck;


   abstract void nowDeck();
   abstract int nowCardCount();
   abstract int sumOfCards();
}
 

class Dealer extends GameParticipant {
   int blackJack;

   public void nowDeck() {
      for (char c : deck) { 
         if(c != 0) {
               System.out.print(c+" "); 
         }
      }
      System.out.println();
   }

   public int nowCardCount() {

      int count = 0;

      for (char c : deck) { 
         if(c != 0) {
               count++;
         }
      } 

      return count;
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





class Player extends GameParticipant {
   Double chips;
   Double insuranceChips;

   int blackJack;
   int insurance;
   int surrender;
   int bust;
 
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

   public int nowCardCount() {

      int count = 0;

      for (char c : deck) { 
         if(c != 0) {
               count++;
         }
      } 

      return count;
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