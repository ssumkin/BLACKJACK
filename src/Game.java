/*
Blackjack
처음 두 장의 카드 합이 21일 경우를 말하며 배팅 금액의 1.5배를 받음

Bust
카드 합이 21을 초과하면 베팅 금액을 잃게 됨

Push
플레이어와 딜러의 각각의 카드 합이 같을 경우 서로 비기게 됩니다.

Stay
테이블 위에서 손을 좌우로 흔든다.
   플레이어가 추가 카드를 원하지 않을 경우를 말하며, 딜러는 카드의 합이 17 이상이면 추가 카드를 받을 수 없습니다.

Hit
테이블 위에서 손가락으로 톡톡 친다. 
   플레이어가 처음 두 장의 카드 외에 딜러에게 추가카드를 요청하는 경우를 말합니다.

Pair Bet
플레이어가 최초로 받게 될 두 장의 카드가 같은 가치를 갖는 카드일거라 예상하고 베팅하는 경우를 말하며,
   당첨 시 베팅 금액의 11배를 지급받게 됨.

Surrender
플레이어가 처음 두 장의 카드로 딜러의 카드를 이길 수 없다고 판단한 경우 게임을 포기하는 것
   이 경우 최초 베팅액의 1/2을 잃게 됩니다.

Insurance
딜러의 오픈 카드가 Ace일 경우 플레이어는 베팅액의 1/2범위 내에서 보험금을 걸 수 있음
   1. 딜러가 블랙잭인 경우 - 보험금의 두 배를 받습니다.
   2. 딜러가 블랙잭이 아닐 경우 - 보험금을 잃게 됩니다.

Even Money
딜러의 오픈 카드가 Ace인 경우, Insurance전에 블랙잭의 핸드를 가지고 있는 플레이어에게 Even Money 여부를 확인하게 됩니다.
   1. Even Money를 선택하게 되면 즉시 베팅액의 1배를 지급받게 됩니다.
   2. (Even Money 를 선택하지 않은 상태에서, 딜러가 블랙잭인 경우 Push 처리 됩니다.)

Double Down
플레이어의 요청 시 한 장의 추가 카드만 받는다는 조건으로 플레이어의 현재 베팅 금액 내에서 추가 베팅을 더 할 수 있음

Split
플레이어가 받은 처음 두 장의 카드가 같은 숫자인 경우에는 두 장의 카드를 나누어서 각각 베팅하여 게임을 진행할 수 있음
   이때 베팅금액은 최초 베팅액과 동일한 금액이어야 합니다.
 */
 

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
   // 맞다면 
   int pairBet() {

      return 0;
   }

   int surrender() { // 서렌치는 것

      return 0;
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

   int doubleDown() { // 한 장의 카드만 더 받고 최초 배팅금액 한도 내에서 추가로 배팅

      return 0;
   }

   // int split() {

   //    return 0;
   // }


}
