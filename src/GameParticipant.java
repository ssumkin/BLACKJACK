public abstract class GameParticipant { // 게임 참가자
    int total;

    public abstract int totalCalc(int[] card);
}

class Dealer extends GameParticipant {
    public int totalCalc(int[] card) {
        int add = 0;
        for(int i = 0; i < card.length; i++) {
            add += card[i];
        }
        return add;
    }
}

class Player extends GameParticipant {
    int chips;

    Player() {}
    Player(int chips) {
        this.chips = chips;
    }

    public int totalCalc(int[] card) {
        int add = 0;
        for(int i = 0; i < card.length; i++) {
            add += card[i];
        }
        return add;
    }
}