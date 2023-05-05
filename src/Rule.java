/*
BLACKJACK
딜러와 플레이어 중 카드의 합이 21 또는 
21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임

A = 1 or 11
2, 3, 4, 5, 6, 7, 8, 9
J, Q, K  = 10

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
 

=사실 색깔을 상관이 없잖아
계산은 숫자로 하는거니까

A ~ K
2차원 배열로
13장씩 4개 

4행 13열 배열로 만들고
A = 1 or 11
J, Q, K = 10





BLACKJACK 
game rule : 카드를 뽑아서 모두 더한 값이 21에 가장 가까운 플레이어가 승리
A = 1 or 11
2, 3, 4, 5, 6, 7, 8, 9
J, Q, K = 10

처음 게임을 시작하면 모두에게 카드 2장씩 배부
첫 2장을 공개하기 전에 Pair Bet 가능 > 같은 가치의 카드인지 배팅 > 맞을 경우 11배의 코인을 받음

각 게임 규칙들 한 클래스로 묶고 메소드화

카드는 총 52장 예정
A, 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K
A, 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K
A, 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K
A, 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K





gameParticipant
dealer
player

게임 참가자 class
딜러와 플레이어 class
처음에 플레이어 숫자 입력 받고 객체 배열 만들어서 객체 생성하기




*/ 


public class Rule {
    void basicRule() {
        System.out.println("BLACKJACK");
        System.out.println("딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임입니다.");
        System.out.println("A = 1 or 11\n2, 3, 4, 5, 6, 7, 8, 9\nJ, Q, K = 10");

    }

    void detailedRules() {
        System.out.println("""
Blackjack
처음 두 장의 카드 합이 21일 경우를 말하며 배팅 금액의 1.5배를 받습니다.

Bust
카드 합이 21을 초과하면 베팅 금액을 잃게 됩니다.

Push
플레이어와 딜러의 각각의 카드 합이 같을 경우 서로 비기게 됩니다.

Stay
플레이어가 추가 카드를 원하지 않을 경우를 말하며, 딜러는 카드의 합이 17 이상이면 추가 카드를 받을 수 없습니다.

Hit
플레이어가 처음 두 장의 카드 외에 딜러에게 추가카드를 요청하는 경우를 말합니다.

Pair Bet
플레이어가 최초로 받게 될 두 장의 카드가 같은 가치를 갖는 카드일거라 예상하고 베팅하는 경우를 말하며, 당첨 시 베팅 금액의 11배를 지급받게 됩니다.

Surrender
플레이어가 처음 두 장의 카드로 딜러의 카드를 이길 수 없다고 판단한 경우 게임을 포기하는 것을 말합니다.
이 경우 최초 베팅액의 1/2을 잃게 됩니다.

Insurance
딜러의 오픈 카드가 Ace일 경우 플레이어는 베팅액의 1/2범위 내에서 보험금을 걸 수 있습니다.
1. 딜러가 블랙잭인 경우 - 보험금의 두 배를 받습니다.
2. 딜러가 블랙잭이 아닐 경우 - 보험금을 잃게 됩니다.

Even Money
딜러의 오픈 카드가 Ace인 경우, Insurance전에 블랙잭의 핸드를 가지고 있는 플레이어에게 Even Money 여부를 확인하게 됩니다.
1. Even Money를 선택하게 되면 즉시 베팅액의 1배를 지급받게 됩니다.
2. (Even Money 를 선택하지 않은 상태에서, 딜러가 블랙잭인 경우 Push 처리 됩니다.)

Double Down
플레이어의 요청 시 한 장의 추가 카드만 받는다는 조건으로 플레이어의 현재 베팅 금액 내에서 추가 베팅을 더 할 수 있습니다.

Split
플레이어가 받은 처음 두 장의 카드가 같은 숫자인 경우에는 두 장의 카드를 나누어서 각각 베팅하여 게임을 진행할 수 있습니다.
이때 베팅금액은 최초 베팅액과 동일한 금액이어야 합니다.
        """);
    }
}