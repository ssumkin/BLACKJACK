import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class BlackJack {
   Scanner scanner = new Scanner(System.in);


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
      
      
      int gamerOfNum = gamer_of_num;
      int endGame = 0; // 각 플레이어 마다 게임이 끝났는지 체크하는 용
      
      Game game = new Game();

      // while(endGame < gamerOfNum) {

      // }  
 
   }


   void gameStart() { 
      CardShuffle cs = new CardShuffle();

      System.out.print("\033[H\033[2J");
      System.out.println("플레이어 숫자를 입력해 주세요. (1 ~ 7 입력 가능)");
      System.out.print(">> ");
      int gamerOfNum = scanner.nextInt(); // 플레이어 전체 숫자 입력

      if(gamerOfNum < 1 || gamerOfNum > 7) {
         System.out.print("\033[H\033[2J");
         System.out.print("플레이어 숫자를 다시 입력해 주세요 : ");
         return;
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

         player[i] = new Player(playerChips); // 플레이어 마다 얼마 있는지 입력
         player[i].deck = new char[deckSize]; // 플레이어 덱 크기 설정
         player[i].deck[0] = cs.drawCard();
         player[i].deck[1] = cs.drawCard();
      }

       
      
      BlackJack blackJack = new BlackJack();
      blackJack.mainGame(gamerOfNum, dealer, player);
      
       

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
               System.out.println("1 ~ 3 사이의 숫자를 입력해 주세요.3");
               System.out.print(">> ");
               break;
            }
         }

           
       
      }
      
        
   }
}







