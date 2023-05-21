import java.util.Scanner;

public class Game {
    
   Double battingChips; 

   Game(double battingChips) {
      this.battingChips = battingChips;
   }
 
   Double blackjack() { //  
      

      battingChips *= 2.5;
 
      return battingChips;
   }

   int bust() { // 카드의 합이 21을 넘은 것 베팅금을 잃게됨

      return 0;
   }

   int push() { // 딜러 & 플레이어의 합이 동일한 경우 비기게 됨

      return 0;
   }

   int stay() { // 카드를 더 뽑지 않고 차례를 마치는 것

      return 0;
   }

   char hit(char card, Player[] player, int player_order) { // 처음 두장에서 만족하지 않고 카드를 더 뽑는 것

      for(int i = 0; i < player[player_order].deck.length; i++) {
         if(player[player_order].deck[i] == 0) {
            player[player_order].deck[i] = card;
            break;
         }
      } 

      System.out.println("새로운 카드 " + card);

      return card;
   }


   char pairBetSwitch(int n) {
      Scanner scanner = new Scanner(System.in);      

      int check = 0;

      System.out.println("예상 카드를 입력해 주세요.");
      System.out.print(">> ");
      char index = scanner.next().charAt(0);

      switch(index) { 
         case 'A':
         case '2':
         case '3':
         case '4':
         case '5':
         case '6':
         case '7':
         case '8':
         case '9':
         case 'J':
         case 'Q':
         case 'K':
            check++;
      }

      if(check == 1) {
         return index;
      } 

      return pairBetSwitch(n);
   }

   // 처음 받는 2개의 카드가 동일한 가치의 카드인지 예측 하는 것
   // 맞다면 11배
   int pairBet() {

      return 0;
   }

   double surrender(Player[] player, int player_order) { // 서렌치는 것 배팅액의 절반 만 잃음
      this.battingChips /= 2;

      for(int i = 0; i < player[player_order].deck.length; i++) {
            player[player_order].deck[i] = 0;
      } 

      return this.battingChips;
   }

// 딜러의 오픈카드가 A일 경우 배팅액의 1/2범위 내에서 보험금 걸기
// 딜러 블랙잭 : 보험금 두 배를 받음
// 딜럭 블랙잭X : 보험금을 잃음   
   int insurance() { 

      return 0;
   }

   /* 본인이 블랙잭이고 딜러의 오픈카드가 A일 때 딜러가 evenMoney를 물어봄
   * 이븐머니를 할 경우 배팅액과 동일한 금액을 받음
   * 안 할 경우 push로 비기거나
   * 블랙잭이 돼서 1.5배의 금액을 추가로 얻을 수 있음    
    */
   int evenMoney() {

      return 0;
   }


   int doubleDownBatting(int n, Player[] player, int player_order, double batting_chips) {
      Scanner scanner = new Scanner(System.in);      

      int addBet; 
      double max;

      if(player[player_order].chips > batting_chips) {
         System.out.println("추가 배팅금을 입력해 주세요. 최대 " + batting_chips + "개의 칩을 걸 수 있습니다.");
         max = batting_chips;
      } else {
         System.out.println("추가 배팅금을 입력해 주세요. 최대 " + player[player_order].chips + "개의 칩을 걸 수 있습니다.");
         max = player[player_order].chips;
      }
      System.out.print(">> ");

      addBet = scanner.nextInt();

      if(addBet > 0 && addBet <= max) {
         n = 0;
      } else {
         System.out.println("배팅 금액을 다시 입력해 주세요.");
      }

      if(n == 0) {
         return addBet;
      }  
      return doubleDownBatting(n, player, player_order, batting_chips);
      
        
   }

   char doubleDown(char card, Player[] player, int player_order, int batting_chips) { // 한 장의 카드만 더 받고 최초 배팅금액 한도 내에서 추가로 배팅
      this.battingChips += batting_chips;

      for(int i = 0; i < player[player_order].deck.length; i++) {
         if(player[player_order].deck[i] == 0) {
            player[player_order].deck[i] = card;
            break;
         }
      } 
 
      System.out.println("새로운 카드 " + card);

      return card; 
   }


   

   // int split() {

   //    return 0;
   // }


}
