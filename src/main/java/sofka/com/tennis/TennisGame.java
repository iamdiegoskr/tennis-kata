package sofka.com.tennis;

public interface TennisGame {
    void wonPoint(String playerName);
    String getScore();
}