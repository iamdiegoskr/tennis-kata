
public class TennisGame1 implements TennisGame {
    
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            scorePlayerOne += 1;
        else
            scorePlayerTwo += 1;
    }

    public String getScore() {
        String score = "";
        if(scorePlayerOne==scorePlayerTwo){
            score = getTieScore();
        }else if(scorePlayerOne >=4 || scorePlayerTwo>=4){
            score = getAdvantage();
        }else{
            score = temporaryScore(score);
        }
        return score;
    }

    private String temporaryScore(String score) {
        for (int i=1; i<3; i++)
        {
            score = score(score, i);
        }
        return score;
    }

    private String score(String score, int i) {

        int tempScore;
        if(i==1){
            tempScore = scorePlayerOne;
        }else{
            score+="-";
            tempScore = scorePlayerTwo;
        }

        return scoreZeroToThree(score, tempScore);
    }

    private String scoreZeroToThree(String score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;
            default:
                score +="";
        }
        return score;
    }

    private String getAdvantage() {
        int minusResult = scorePlayerOne - scorePlayerTwo;
        String score = "";
        StringBuilder stringBuilder = new StringBuilder();
        switch (minusResult){
            case 1:
                score = stringBuilder.append("Advantage ").append(this.player1Name).toString();
                break;
            case -1:
                score = stringBuilder.append("Advantage ").append(this.player2Name).toString();
                break;
            default:
                if ((minusResult >= 2)) {
                    score = stringBuilder.append("Win for ").append(this.player1Name).toString();
                } else {
                    score = stringBuilder.append("Win for ").append(this.player2Name).toString();
                }
        }
        return score;
    }

    private String getTieScore() {
        switch (this.scorePlayerOne)
        {
            case 0:
                    return "Love-All";
            case 1:
                    return "Fifteen-All";
            case 2:
                    return "Thirty-All";
            default:
                    return "Deuce";
        }
    }
}
