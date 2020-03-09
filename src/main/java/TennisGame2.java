public class TennisGame2 implements TennisGame {
    public transient int scoreFirstPlayer;
    public transient int scoreSecondPlayer;

    public TennisGame2(final String player1Name,final String player2Name) {

    }

    @Override
    public String getScore() {
        String score;
        final String[] scoresArray = {"Love", "Fifteen", "Thirty", "Forty"};
        final String[] advantage = {"Advantage ", "Win for "};


        if (isDraw()) {
            score = isLessThan(3)
                    ? scoresArray[this.scoreFirstPlayer] + "-All"
                    : "Deuce";
        } else if (isEqualGreaterForty()) {
            score = Math.abs(difference())==1
                    ? advantage[0] + getCurrentWinner()
                    : advantage[1] + getCurrentWinner();

        }else{
            score = scoresArray[scoreFirstPlayer] + "-" + scoresArray[scoreSecondPlayer];
        }
        return score;
    }

    public String getCurrentWinner() {
        String playerName;
        if (difference() < 0) {
            playerName = "player2";
        } else {
            playerName = "player1";
        }
        return playerName;
    }

    public boolean isEqualGreaterForty(){
        return this.scoreFirstPlayer >= 4 || this.scoreSecondPlayer >= 4 ? true : false;
    }

    public int difference() {
        return this.scoreFirstPlayer - this.scoreSecondPlayer;
    }

    private boolean isLessThan(final int score) {
        return this.scoreFirstPlayer < score;
    }

    private boolean isDraw() {
        return scoreFirstPlayer == scoreSecondPlayer;
    }

    public void scorePlayer1() {
        scoreFirstPlayer++;
    }

    public void scorePlayer2() {
        scoreSecondPlayer++;
    }
    @Override
    public void wonPoint(final String player) {
        if ("player1".equalsIgnoreCase(player)) {
            scorePlayer1();
        }else {
            scorePlayer2();
        }
    }
}