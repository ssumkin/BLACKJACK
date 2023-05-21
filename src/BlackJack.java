import java.util.Scanner;
import java.lang.Math;

public class BlackJack {
   Scanner scanner = new Scanner(System.in);
   CardShuffle cs;

   BlackJack() {
      cs = new CardShuffle();
   }

   void gameDescription() { // 초기 게임 안내
      System.out.print("\033[H\033[2J"); // 터미널 청소
      System.out.println("BLACKJACK");
      System.out.println("1. 게임 시작");
      System.out.println("2. 게임 규칙");
      System.out.println("3. 게임 종료");
      System.out.println("숫자를 입력해 주세요.");
      System.out.println("===========================");
      System.out.print(">> ");
   }

   void mainGame(int gamer_of_num, Dealer dealer, Player[] player) {
      Game[] game = new Game[gamer_of_num];

      int endGame = 0; // 각 플레이어 마다 게임이 끝났는지 체크하는 용
      int[] playerEndGame = new int[gamer_of_num];

      int round = 0; // 게임 횟수 > 2장을 처음 받았을 때만 가능한 것들이 있기 때문
      int userChoice;
      double bettingChips = 0.0;
      boolean mainGameLoop = true;
      int pairBetCheck;
      double pairbetChips;
      double insuranceChips = 0;

      double returnChips = 0.0;

      for(int i = 0; i < game.length; i++) {
         System.out.print("Player" + (i+1) + "의 배팅 금액 입력 : "); 
         bettingChips = scanner.nextDouble();

         if(player[i].chips < bettingChips) {
            System.out.println("현재 칩 개수 : " + player[i].chips);
            System.out.println("가지고 있는 칩보다 배팅을 많이 할 수 없습니다. 다시 입력해 주세요.");
            i--;
            continue;
         }

         player[i].chips -= bettingChips;
         game[i] = new Game(bettingChips);
      }
      
      System.out.print("\033[H\033[2J");  
      
 
      while(mainGameLoop) {
         for(int i = 0; i < player.length; i++) {

            if(playerEndGame[i] == 1) { // 게임 끝난 플레이어에겐 묻지 않고 넘기기
               continue;
            }
 
            if(round == 0 && player[i].chips > 0) { // 페어뱃 처리 
               System.out.println("Player" + (i+1) + "님 페어베팅을 하시겠습니까?");
               System.out.println("페어베팅을 하신다면 1번을 하지 않으신다면 아무 숫자나 입력해 주세요.");
               System.out.print(">> ");

               pairBetCheck = scanner.nextInt();

               if(pairBetCheck == 1) { 
                  pairbetChips = game[i].pairbetBetting(1, player, i, bettingChips);
                  player[i].chips -= pairbetChips;

                  game[i].pairBet(player, i, pairbetChips); 
                  
               }
               continue;
            }

            System.out.println("Dealer open card [" + dealer.deck[0] + "]");
            System.out.print("Player" + (i+1) + " 현재 덱 : ");
            player[i].nowDeck();
            int playerSum = player[i].sumOfCards();
            System.out.println("현재 덱 합계 : " + playerSum);
 
            if(player[i].nowCardCount() == 2 && playerSum == 21) { // 플레이어 블랙잭 확인
               player[i].blackJack = 1;
            }
            if(dealer.nowCardCount() == 2 && dealer.sumOfCards() == 21) { // 딜러 블랙잭 확인
               dealer.blackJack = 1;
            }

            if(playerSum > 21) {
               game[i].bust(player, i);
               playerEndGame[i]++;
               continue;
            }

            userChoice = game[i].gameChoice(1, player, i, player[i].nowCardCount());
            
            switch(userChoice) { 
               case 1:
                  game[i].hit(cs.drawCard(), player, i);
                  break;
               case 2: // stay > 안 뽑고 종료
                  playerEndGame[i]++;
                  break;
               case 3: // 더블다운
                  int addBetChips = game[i].doubleDownBetting(1, player, i, bettingChips);
                  game[i].doubleDown(cs.drawCard(), player, i, addBetChips); 
                  break; 
               case 4: // 보험금
                  insuranceChips = game[i].insuranceBetting(1, player, i, bettingChips);
                  player[i].insurance = 1;
                  game[i].insurance(insuranceChips);
                  break; 
               case 5: // 서렌
                  game[i].surrender(player, i);  
                  playerEndGame[i]++;
                  break;
            }
            
         }
         
         round++;
         endGame = 0;
         for (int i : playerEndGame) {
            endGame += i; 
         }
 

         if(endGame == gamer_of_num) { // 마지막 반복문 > 이 때 딜러 카드 연달아 뽑기
            mainGameLoop = false; 
         } 
 
      } 
      for(int i = 2; ; i++) {
         if(dealer.sumOfCards() >= 17) {
            break;
         }
         dealer.deck[i] = cs.drawCard();  
      }

      System.out.print("\033[H\033[2J");  

      for(int i = 0; i < player.length; i++) {
         String winLoseCheck = "";
         int dealerSum = dealer.sumOfCards() > 21 ? 0 : dealer.sumOfCards();
         int playerSum = player[i].sumOfCards() > 21 ? 0 : player[i].sumOfCards();

         System.out.print("딜러 덱 : ");
         dealer.nowDeck();
         System.out.print("Player" + (i+1) + " 덱 : ");
         player[i].nowDeck();

          

         if(playerSum > dealerSum && player[i].surrender != 1) { // 승리
            returnChips = game[i].bettingChips * 2;  
            if(player[i].blackJack > 0) { // 블랙잭 승리
               returnChips = game[i].bettingChips * 2.5;  
            }
            winLoseCheck = "승리!";

         } else if(playerSum == dealerSum && player[i].bust != 1 && player[i].surrender != 1) { // 비김
            returnChips = game[i].bettingChips;
            winLoseCheck = "비김";
         } else {
            returnChips = 0;
            winLoseCheck = "패배ㅠ";
         }

         if(player[i].surrender == 1) {
            returnChips = game[i].bettingChips;
         }

         if(player[i].insurance > 0) {
            if(dealer.blackJack == 1) {
               insuranceChips *= 2;
               player[i].chips += insuranceChips;
            } else {
               insuranceChips = 0;
            }
         }

         player[i].chips += returnChips;

         System.out.println("Player" + (i+1) + " " + winLoseCheck);
         System.out.println("칩 : " + player[i].chips + "\n");

          
      }
      
 

   }





   void gameStart() {  

      System.out.print("\033[H\033[2J");
      System.out.println("플레이어 숫자를 입력해 주세요. (1 ~ 7 입력 가능)");
      System.out.print(">> ");
      int gamerOfNum = 0;
      boolean playerLoop = true;

      while(playerLoop) {
         gamerOfNum = scanner.nextInt(); // 플레이어 전체 숫자 입력

         if(gamerOfNum < 1 || gamerOfNum > 7) {
            System.out.print("\033[H\033[2J");
            System.out.println("플레이어 숫자를 다시 입력해 주세요. (1 ~ 7 입력 가능)");
            System.out.print(">> ");
         } else {
            playerLoop = false;
         }
      }

      int deckSize = (int)Math.ceil(52 / (gamerOfNum + 1));  

      Dealer dealer = new Dealer(); // 딜러 객체 생성
      dealer.deck = new char[deckSize]; // 딜러 덱 크기 설정
 
      dealer.deck[0] = cs.drawCard();
      dealer.deck[1] = cs.drawCard();

      Player[] player = new Player[gamerOfNum]; // 플레이어 객체 배열 생성
      for(int i = 0; i < player.length; i++) { // 플레이어마다 객체 생성
         System.out.print("Player" + (i+1) + " 칩 개수 입력 : ");
         Double playerChips = scanner.nextDouble();

         if(playerChips <= 0) {
            System.out.println("칩 개수 다시 입력해 주세요.");
            i--;
            continue;
         }

         player[i] = new Player(playerChips); // 플레이어 마다 얼마 있는지 입력
         player[i].deck = new char[deckSize]; // 플레이어 덱 크기 설정
         player[i].deck[0] = cs.drawCard();
         player[i].deck[1] = cs.drawCard();
      }


      boolean gameRetryLoop = true; 
        
      while(gameRetryLoop) {
         this.mainGame(gamerOfNum, dealer, player);
         
         for(int i = 0; i < cs.cardList.length; i++) {
            cs.cardList[i].clear(); 
         }
         cs.shuffle();  

         dealer.deck[0] = cs.drawCard();
         dealer.deck[1] = cs.drawCard();
         dealer.deck[2] = 0;
         dealer.deck[3] = 0;
         for(int i = 0; i < player.length; i++) {  
            player[i].deck[0] = cs.drawCard();
            player[i].deck[1] = cs.drawCard();
            player[i].deck[2] = 0;
            player[i].deck[3] = 0;
            player[i].deck[4] = 0;
         }
      } 
   }


   void showRule() { // 게임 규칙 설명
      Scanner scanner = new Scanner(System.in);
      
      Rule rule = new Rule();
      System.out.print("\033[H\033[2J");
      rule.basicRule();

      System.out.println("상세 규칙을 보려면 'd'를 입력해 주세요.");
      System.out.println("그 외의 키를 누를 경우 게임 화면으로 넘어갑니다.");
      System.out.println("===========================");
      System.out.print(">> ");

      char detail = scanner.next().charAt(0);
   
      if(detail == 'd') {
         System.out.print("\033[H\033[2J");
         rule.detailedRules();
         System.out.println("규칙을 그만 보시려면 아무키나 입력해주세요.");
         System.out.print(">> ");
         
         if(scanner.hasNext()) {
            System.out.print("\033[H\033[2J");
            gameDescription();
         }
      } else {
         System.out.print("\033[H\033[2J");
         gameDescription();
      }
      
   }



   public static void main(String[] args) { 
      BlackJack blackJack = new BlackJack(); 
      blackJack.gameDescription();
      boolean gameLoop = true; 
      while(gameLoop) {
         
         int game = blackJack.scanner.nextInt();
         switch(game) {
            case 1: {
               blackJack.gameStart();
               break;
            }
            case 2: {
               blackJack.showRule();
               break;
            }
            case 3: {
               System.out.println("게임을 종료합니다.");
               gameLoop = false;
               break;
            }
            default: { 
               System.out.println("1 ~ 3 사이의 숫자를 입력해 주세요.");
               System.out.print(">> ");
               break;
            }
         } 
      }  
   }
}







