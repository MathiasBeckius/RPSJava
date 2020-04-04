package rockpaperscissors;

/**
 * Play Rock-Paper-Scissors, where two players can compete
 * in a "best of 1, 3, 5 or 7 rounds" game.
 *
 * Start the game (best of 3 rounds):
 *      Tally tally = Game.newTally(3);
 *
 * Update tally (evaluate handshapes, update score):
 *      tally = Game.updatedTally(tally, handP1, handP2);
 * Note that the old instance is "thrown away"! Each instance of the Tally
 * is immutable.
 *
 * Check if the game has ended:
 *      if (tally.remainingNrOfRounds() == 0)
 */
public final class Game
{
    /**
     * Create a new tally.
     * @param nrOfRounds Number of rounds to play. Must be 1, 3, 5 or 7.
     * @throws IllegalArgumentException If nrOfRounds is invalid.
     * @return Tally with initialized score, etc.
     */
    public static Tally newTally(int nrOfRounds)
    {
        return new RPSTally(nrOfRounds);
    }

    /**
     * Create an updated tally.
     *
     * The players chosen handshapes will be evaluated. The tally will also
     * be updated with score and the last used handshapes.
     *
     * If one of the players has won a majority of the rounds, then the game
     * is finished.
     *
     * If it's a draw after all rounds, then the game continues until we
     * have a winner.
     * @param tally Current instance of the tally.
     * @param p1 Hand of Player 1.
     * @param p2 Hand of Player 2.
     * @throws NullPointerException If any of the parameters are null.
     * @throws UnsupportedOperationException If the game has already ended.
     * @throws IllegalArgumentException If any of the parameters are invalid
     * instances.
     * @return Tally with updated score, etc.
     */
    public static Tally updatedTally(Tally tally, HandShape p1, HandShape p2)
    {
        return RPSTally.update(Game.rpsTally(tally), new ResultOfRound(p1, p2));
    }

    private static RPSTally rpsTally(Tally tally)
    {
        if (tally == null)
            throw new NullPointerException();

        try
        {
            return (RPSTally)tally;
        }
        catch (ClassCastException e)
        {
            throw new IllegalArgumentException();
        }
    }
}
