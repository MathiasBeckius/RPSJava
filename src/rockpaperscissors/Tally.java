package rockpaperscissors;

/**
 * Play Rock-Paper-Scissors, where two players can compete
 * in a "best of 1, 3, 5 or 7 rounds" game.
 *
 * Start the game (best of 3 rounds):
 *      Tally tally = new Tally(3);
 *
 * Update tally (evaluate handshapes, update score):
 *      tally = tally.update(handP1, handP2);
 * Note that the old instance is "thrown away"! Each instance of the Tally
 * is immutable.
 *
 * Check if the game has ended:
 *      if (tally.remainingNrOfRounds() == 0)
 */
final public class Tally
{
    private int nrOfRounds, scoreP1, scoreP2;

    /**
     * @brief Create a new tally.
     * @param nrOfRounds Number of rounds to play. Must be 1, 3, 5 or 7.
     * @throws IllegalArgumentException If nrOfRounds is invalid.
     * @return Tally with initialized score, etc.
     */
    public Tally(int rounds)
    {
        this(Tally.validateNrOfRounds(rounds), 0, 0);
    }

    private Tally(int rounds, int p1Score, int p2Score)
    {
        nrOfRounds = rounds;
        scoreP1 = p1Score;
        scoreP2 = p2Score;
    }

    /**
     * Return current score for Player 1.
     */
    public int scorePlayer1()
    {
        return scoreP1;
    }

    /**
     * Return current score for Player 2.
     */
    public int scorePlayer2()
    {
        return scoreP2;
    }

    /**
     * Return remaining number of rounds.
     */
    public int remainingNrOfRounds()
    {
        return nrOfRounds;
    }

    private static int validateNrOfRounds(int nr)
    {
        if ((nr >= 1) && (nr <= 7) && (nr % 2 == 1))
            return nr;
        throw new IllegalArgumentException();
    }

    public Tally player1Wins()
    {
        return updateTally(1, 0);
    }

    public Tally player2Wins()
    {
        return updateTally(0, 1);
    }

    public Tally nobodyWins()
    {
        return updateTally(0, 0);
    }

    private Tally updateTally(int pointsP1, int pointsP2)
    {
        if (remainingNrOfRounds() == 0)
            throw new UnsupportedOperationException();

        int scoreP1 = scorePlayer1() + pointsP1;
        int scoreP2 = scorePlayer2() + pointsP2;

        int remainingNrOfRounds = Tally.calcRemainingNrOfRounds(
            remainingNrOfRounds(), scoreP1, scoreP2);

        return new Tally(remainingNrOfRounds, scoreP1, scoreP2);
    }

    private static int calcRemainingNrOfRounds(
        int nrOfRounds, int scoreP1, int scoreP2)
    {
        int rounds = nrOfRounds - 1;

        // If it's a draw when all rounds are played...
        if ((rounds == 0) && (scoreP1 == scoreP2))
            return 1; // Play another round

        // If one player has won most rounds...
        if ((Math.max(scoreP1, scoreP2) > rounds) && (scoreP1 != scoreP2))
            return 0; // Then we have a winner - stop playing

        // Keep playing
        return rounds;
    }
}
