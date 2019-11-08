package rockpaperscissors;

/**
 * Tally for a game of Rock-Paper-Scissors.
 */
public class Tally
{
    private int nrOfRounds, scoreP1, scoreP2;
    private String handP1, handP2;

    /**
     * Creates a new tally.
     * @param nrOfRounds Number of rounds to play.
     * @throws IllegalArgumentException If nrOfRounds is negative.
     */
    public Tally(int nrOfRounds) { this(nrOfRounds, 0, 0, null, null); }

    /**
     * Creates an updated tally.
     * @param result Result from round (score and player's hands).
     * @return Updated tally.
     */
    public Tally update(ResultOfRound result)
    {
        return new Tally(
            this.nrOfRounds - 1,
            this.scoreP1 + result.scorePlayer1(),
            this.scoreP2 + result.scorePlayer2(),
            result.handPlayer1(),
            result.handPlayer2());
    }

    /**
     * Return last hand shape of Player 1.
     * @throws UnsupportedOperationException If first round has not been played,
     * i.e. no hands registered in tally.
     */
    public String handPlayer1() { return this.checkRef(this.handP1); }

    /**
     * Return last hand shape of Player 2.
     * @throws UnsupportedOperationException If first round has not been played,
     * i.e. no hands registered in tally.
     */
    public String handPlayer2() { return this.checkRef(this.handP2); }

    /**
     * Return current score for Player 1.
     */
    public int scorePlayer1() { return this.scoreP1; }

    /**
     * Return current score for Player 2.
     */
    public int scorePlayer2() { return this.scoreP2; }

    /**
     * Return remaining number for rounds.
     */
    public int remainingNrOfRounds() { return this.nrOfRounds; }

    private Tally(
        int nrOfRounds,
        int scoreP1, int scoreP2,
        String handP1, String handP2)
    {
        if (nrOfRounds < 0)
            throw new IllegalArgumentException(
                "nrOfRounds can't be less than 0!");
        this.nrOfRounds = nrOfRounds;
        this.scoreP1 = scoreP1;
        this.scoreP2 = scoreP2;
        this.handP1 = handP1;
        this.handP2 = handP2;
    }

    private String checkRef(String hand)
    {
        if (hand == null)
            throw new UnsupportedOperationException(
                "First round has not been played yet!");
        return hand;
    }
}
