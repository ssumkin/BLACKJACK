public abstract class GameParticipant { // 게임 참가자
    int total;
    char[] deck;

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
    Double chips;

    Player() {}
    Player(Double chips) {
        this.chips = chips;
    }

    public char[] nowDeck(char[] card) {
        

        return deck;
    }

    public int totalCalc(int[] card) {
        int add = 0;
        for(int i = 0; i < card.length; i++) {
            add += card[i];
        }
        return add;
    }
}