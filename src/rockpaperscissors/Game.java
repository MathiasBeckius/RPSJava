package rockpaperscissors;

/**
 * Play Rock-Paper-Scissors, where two players can compete
 * in a "best of 1, 3, 5 or 7 rounds" game.
 *
 * 1) Start the game (best of 3 rounds):
 *      Game game = new Game(3);
 *
 * 2) Evaluate handshapes (and updated tally):
 *      game = game.evaluate(handP1, handP2);
 * Note that the old instance is "thrown away"! Each instance of the Game class
 * is immutable.
 *
 * 3) Read tally, e.g. for presenting it nicely to the user:
 *      Tally tally = game.tally();
 *
 * 4) Check if the game has ended:
 *      if (game.hasEnded())
 *
 */
public class Game
{
    private RPSTally tally;

    /**
     * Start a new game.
     * @param nrOfRounds Number of rounds to play. Must be 1, 3, 5 or 7.
     * @throws IllegalArgumentException If nrOfRounds is invalid.
     */
    public Game(int nrOfRounds)
    {
        if (!this.validNrOfRounds(nrOfRounds))
            throw new IllegalArgumentException();
        this.tally = new RPSTally(nrOfRounds);
    }

    /**
     * Evaluate the result of the players chosen handshapes. The tally will also
     * be updated with score and the last used handshapes.
     *
     * If one of the players has won a majority of the rounds, then the game
     * is finished.
     *
     * If it's a draw after all rounds, then the game continues until we
     * have a winner.
     * @param p1 Hand of Player 1.
     * @param p2 Hand of Player 2.
     * @throws UnsupportedOperationException If the game has already ended.
     * @throws IllegalArgumentException If invalid handshapes (or null) are
     * passed as arguments.
     * @return A new instance of the Game class.
     */
    public Game evaluate(HandShape p1, HandShape p2)
    {
        if (this.hasEnded())
            throw new UnsupportedOperationException();

        ComparableHandShape cP1 = (ComparableHandShape) p1;
        ComparableHandShape cP2 = (ComparableHandShape) p2;
        return new Game(this.tally.update(new ResultOfRound(cP1, cP2)));
    }

    /**
     * Returns the current instance of the tally, e.g. to be presented through
     * the user interface.
     */
    public Tally tally() { return this.tally; }

    /**
     * Checks if the game has ended.
     */
    public boolean hasEnded() { return this.tally.remainingNrOfRounds() == 0; }

    private Game(RPSTally tally) { this.tally = tally; }

    private boolean validNrOfRounds(int nr)
    {
        return (nr >= 1) && (nr <= 7) && (nr % 2 == 1);
    }
}
