package rockpaperscissors;

public class RPSTally implements Tally
{
    private int nrOfRounds, scoreP1, scoreP2;
    private String handP1, handP2;

    /**
     * @brief Create a new tally.
     * @param nrOfRounds Number of rounds to play. Must be 1, 3, 5 or 7.
     * @throws IllegalArgumentException If nrOfRounds is invalid.
     * @return Tally with initialized score, etc.
     */
    public RPSTally(int rounds)
    {
        this(RPSTally.validateNrOfRounds(rounds), 0, 0, null, null);
    }

    private RPSTally(
        int rounds, int p1Score, int p2Score, String p1Hand, String p2Hand)
    {
        nrOfRounds = rounds;
        scoreP1 = p1Score;
        scoreP2 = p2Score;
        handP1 = p1Hand;
        handP2 = p2Hand;
    }

    public String handPlayer1()      { return RPSTally.checkRef(handP1); }
    public String handPlayer2()      { return RPSTally.checkRef(handP2); }
    public int scorePlayer1()        { return scoreP1; }
    public int scorePlayer2()        { return scoreP2; }
    public int remainingNrOfRounds() { return nrOfRounds; }

    private static int validateNrOfRounds(int nr)
    {
        if ((nr >= 1) && (nr <= 7) && (nr % 2 == 1))
            return nr;
        throw new IllegalArgumentException();
    }

    public RPSTally update(HandShape p1, HandShape p2)
    {
        if (remainingNrOfRounds() == 0)
            throw new UnsupportedOperationException();

        ResultOfRound result = new ResultOfRound(p1, p2);
        int scoreP1 = scorePlayer1() + result.scorePlayer1();
        int scoreP2 = scorePlayer2() + result.scorePlayer2();

        int remainingNrOfRounds = RPSTally.calcRemainingNrOfRounds(
            remainingNrOfRounds(), scoreP1, scoreP2);

        return new RPSTally(
            remainingNrOfRounds,
            scoreP1, scoreP2,
            result.handPlayer1(), result.handPlayer2());
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

    private static String checkRef(String hand)
    {
        if (hand == null)
            throw new UnsupportedOperationException();
        return hand;
    }
}
