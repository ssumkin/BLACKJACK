import java.util.Scanner;

public class Game {
    
   Double bettingChips; 
   Scanner scanner;

   Game(double bettingChips) {
      this.bettingChips = bettingChips;
      scanner = new Scanner(System.in);
   }
 
   int gameChoice(int repeat_num, Player[] player, int player_order, int now_card_count) { 
      System.out.println("HIT(1), STAY(2), DOUBLEDOWN(3), INSURANCE(4), SURRENDER(5)");
      System.out.print(">> ");
      int userChoice = scanner.nextInt();
      
      if(!(userChoice > 0 || userChoice < 6)) {
         System.out.println("1 ~ 5 사이의 숫자를 입력해 주세요.");
      } else {
         repeat_num = 0;
      }
      
      if(userChoice == 3) {
         if(now_card_count > 2) {
            System.out.println("DOUBLEDOWN은 첫 라운드에만 할 수 있습니다.");
            repeat_num = 1;
         }
      }

      if(player[player_order].chips <= 0) {
         if(userChoice == 3) {
            System.out.println("추가 배팅할 수 있는 칩이 없습니다.");
            repeat_num = 1;
         }
      }

      if(repeat_num == 0) {
         return userChoice;
      } else {
         System.out.println("다시 입력해 주세요.");
      }

      return gameChoice(repeat_num, player, player_order, now_card_count);
   }

   Double blackjack() { //  
      bettingChips *= 2.5;
      return bettingChips;
   }

   void bust(Player[] player, int player_order) { // 카드의 합이 21을 넘은 것 베팅금을 잃게됨
      bettingChips = 0.0; 
      player[player_order].bust = 1;
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

   double pairbetBetting(int repeat_num, Player[] player, int player_order, double betting_chips) {
      int addBet; 
      double max;

      System.out.println("배팅금을 입력해 주세요. 최대 " + player[player_order].chips + "개의 칩을 걸 수 있습니다.");
      max = player[player_order].chips;
      System.out.print(">> ");

      addBet = scanner.nextInt();

      if(addBet > 0 && addBet <= max) {
         repeat_num = 0;
      } else {
         System.out.println("배팅 금액을 다시 입력해 주세요.");
      }

      if(repeat_num == 0) {
         return addBet;
      }  
      return pairbetBetting(repeat_num, player, player_order, betting_chips);
 
   }


   // 처음 받는 2개의 카드가 동일한 가치의 카드인지 예측 하는 것
   // 맞다면 11배
   void pairBet(Player[] player, int player_order, double pair_betting_chips) { 

      if(player[player_order].deck[0] == player[player_order].deck[1]) {
         pair_betting_chips *= 12;
      } else {
         pair_betting_chips = 0;
      }

      player[player_order].chips += pair_betting_chips;

      if(pair_betting_chips > 0) {
         System.out.println("축하합니다. 페어베팅을 성공했습니다.");
         System.out.println("현재 칩 개수 : " + player[player_order].chips);
      } else {
         System.out.println("페어베팅을 실패했습니다.");
         System.out.println("현재 칩 개수 : " + player[player_order].chips);
      } 
 
   }

   void surrender(Player[] player, int player_order) { // 서렌치는 것 배팅액의 절반 만 잃음
      bettingChips /= 2; 
      player[player_order].surrender = 1;
   }

 

   double insuranceBetting(int repeat_num, Player[] player, int player_order, double betting_chips) { 
      int addBet; 
      double max;
      double insuranceChips = betting_chips / 2;

      if(player[player_order].chips > insuranceChips) {
         System.out.println("인슈어런스 배팅금을 입력해 주세요. 최대 " + insuranceChips + "개의 칩을 걸 수 있습니다.");
         max = insuranceChips;
      } else {
         System.out.println("인슈어런스 배팅금을 입력해 주세요. 최대 " + player[player_order].chips + "개의 칩을 걸 수 있습니다.");
         max = player[player_order].chips;
      }
      System.out.print(">> ");

      addBet = scanner.nextInt();

      if(addBet > 0 && addBet <= max) {
         repeat_num = 0;
         bettingChips -= addBet;
      } else {
         System.out.println("배팅 금액을 다시 입력해 주세요.");
      }

      if(repeat_num == 0) {
         return addBet;
      }  
      return insuranceBetting(repeat_num, player, player_order, betting_chips);
   }

// 딜러의 오픈카드가 A일 경우 배팅액의 1/2범위 내에서 보험금 걸기
// 딜러 블랙잭 : 보험금 두 배를 받음
// 딜럭 블랙잭X : 보험금을 잃음   
   void insurance(double insurance_chips) { 
      bettingChips -= insurance_chips;
   }

   /* 본인이 블랙잭이고 딜러의 오픈카드가 A일 때 딜러가 evenMoney를 물어봄
   * 이븐머니를 할 경우 배팅액과 동일한 금액을 받음
   * 안 할 경우 push로 비기거나
   * 블랙잭이 돼서 1.5배의 금액을 추가로 얻을 수 있음    
   * 
   * 이븐 머니 제외
    */
   // int evenMoney() {

   //    return 0;
   // }


   int doubleDownBetting(int repeat_num, Player[] player, int player_order, double betting_chips) {   

      int addBet; 
      double max;

      if(player[player_order].chips > betting_chips) {
         System.out.println("추가 배팅금을 입력해 주세요. 최대 " + betting_chips + "개의 칩을 걸 수 있습니다.");
         max = betting_chips;
      } else {
         System.out.println("추가 배팅금을 입력해 주세요. 최대 " + player[player_order].chips + "개의 칩을 걸 수 있습니다.");
         max = player[player_order].chips;
      }
      System.out.print(">> ");

      addBet = scanner.nextInt();

      if(addBet > 0 && addBet <= max) {
         repeat_num = 0;
      } else {
         System.out.println("배팅 금액을 다시 입력해 주세요.");
      }

      if(repeat_num == 0) {
         return addBet;
      }  
      return doubleDownBetting(repeat_num, player, player_order, betting_chips);
      
        
   }

   char doubleDown(char card, Player[] player, int player_order, int betting_chips) { // 한 장의 카드만 더 받고 최초 배팅금액 한도 내에서 추가로 배팅
      this.bettingChips += betting_chips;

      for(int i = 0; i < player[player_order].deck.length; i++) {
         if(player[player_order].deck[i] == 0) {
            player[player_order].deck[i] = card;
            break;
         }
      } 
 
      System.out.println("새로운 카드 " + card);

      return card; 
   }


   

   // 스플릿 제외
   // int split() {
   //    return 0;
   // }


}
