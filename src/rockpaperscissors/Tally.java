package rockpaperscissors;

/**
 * Tally interface for the game of Rock-Paper-Scissors.
 */
public interface Tally
{
    /**
     * Return last hand shape of Player 1.
     * @throws UnsupportedOperationException If first round has not been played,
     * i.e. no hands registered in tally.
     */
    public String handPlayer1();

    /**
     * Return last hand shape of Player 2.
     * @throws UnsupportedOperationException If first round has not been played,
     * i.e. no hands registered in tally.
     */
    public String handPlayer2();

    /**
     * Return current score for Player 1.
     */
    public int scorePlayer1();

    /**
     * Return current score for Player 2.
     */
    public int scorePlayer2();
}
