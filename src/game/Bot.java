package game;

/**
 * A class representing a Bot player of the game. A bot player is an AI player.
 */
public class Bot extends Player{
    public enum BotDifficulty{
        HUMAN,
        EASY, MEDIUM, HARD,
        CHALLENGE,
    }

    private BotDifficulty difficulty;

    public Bot(int pid, BotDifficulty difficulty) {
        super(pid);
    }
}
