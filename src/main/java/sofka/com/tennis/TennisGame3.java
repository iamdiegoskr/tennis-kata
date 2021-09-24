package sofka.com.tennis;

public class TennisGame3 implements TennisGame {

    private int scorePlayerOne;
    private int scorePlayerTwo;

    private final String namePlayerOne;
    private final String namePlayerTwo;


    public TennisGame3(String puntNam1, String puntNan2) {
        this.namePlayerOne = puntNam1;
        this.namePlayerTwo = puntNan2;
    }


    public String getScore() {
        if (scores()) {
            return scoreResult();
        }

        if (isTie()) {
            return "Deuce";
        }
        
        return getWinner();
    }

    public void wonPoint(String playerName) {
        if(playerName.equals("player1")){
            scorePlayerTwo++;
        }
        if(playerName.equals("player2")){
            scorePlayerOne++;
        }
    }

    public boolean scores(){
        return (scorePlayerTwo < 4) && (scorePlayerOne < 4) && (scorePlayerTwo + scorePlayerOne != 6);
    }

    public boolean isTie(){
        return scorePlayerTwo == scorePlayerOne;
    }

    public String getWinner(){
        return ( raiseSubtraction() == 1) ? "Advantage " + playerForward() : "Win for " + playerForward();
    }

    public double raiseSubtraction(){
        return Math.pow((scorePlayerTwo - scorePlayerOne), 2);
    }

    public String playerForward(){
        return scorePlayerTwo > scorePlayerOne ? namePlayerOne : namePlayerTwo;
    }

    public String scoreResult(){
        String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (scorePlayerTwo == scorePlayerOne) ?
                scores[scorePlayerTwo] + "-All" :
                scores[scorePlayerTwo] + "-" + scores[scorePlayerOne];
    }


}