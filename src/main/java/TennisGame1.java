import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equalsIgnoreCase("player1")) {
            scorePlayer1 += 1;
        }else {
            scorePlayer2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (isDraw()){
            score = definirScoreDeEmpate();
        }else if (isAdvantage()){
            score = getAdvantage();
        }else{
            score = validarScore(score);
        }
        return score;
    }

    private boolean isDraw() {
        return scorePlayer1 == scorePlayer2;
    }

    private String definirScoreDeEmpate() {
        String [] drawScore = {"Love-All", "Fifteen-All","Thirty-All"};
        return ScoreInGame()<3 ? drawScore[ScoreInGame()]: "Deuce";
    }

    private int ScoreInGame() {
        return scorePlayer1;
    }

    private boolean isAdvantage() {
        return scorePlayer1 >=4 || scorePlayer2 >=4;
    }

    private String getAdvantage() {
        int minusResult = scorePlayer1 - scorePlayer2;
        Map<Integer, String> mapOfState = new HashMap<>();
        mapOfState.put(1,"Advantage player1");
        mapOfState.put(-1,"Advantage player2");
        mapOfState.put(2,"Win for player1");
        mapOfState.put(3,"Win for player1");
        mapOfState.put(4,"Win for player1");
        return mapOfState.getOrDefault(minusResult,"Win for player2");
    }

    private String validarScore(String score) {

        String[] scorePlayer = {"Love","Fifteen","Thirty","Forty"};
        score += scorePlayer[scorePlayer1] + "-" + scorePlayer[scorePlayer2];
        return score;
    }

}
