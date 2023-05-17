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

   // 처음 받는 2개의 카드가 동일한 가치의 카드인지 예측 하는 것
   // 맞다면 11배
   int pairBet() {

      return 0;
   }

   double surrender(Player[] player, int player_order) { // 서렌치는 것 배팅액의 절반 만 잃음
      this.battingChips = 0.0;

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
