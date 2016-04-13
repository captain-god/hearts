package game;

/**
 * A class representing a Bot player of the game. A bot player is an AI player.
 */
public class Bot extends Player{
    public enum Difficulty {
        HUMAN,
        EASY, MEDIUM, HARD,
        CHALLENGE,
    }

    private Difficulty difficulty;

    public Bot(int pid, Difficulty difficulty) {
        super(pid);
    }
}
