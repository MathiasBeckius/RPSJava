package rockpaperscissors;

/**
 * Tally for a game of Rock-Paper-Scissors.
 */
class RPSTally implements Tally
{
    private int nrOfRounds, scoreP1, scoreP2;
    private String handP1, handP2;

    /**
     * Creates a new tally.
     * @param nrOfRounds Number of rounds to play.
     * @throws IllegalArgumentException If nrOfRounds is negative.
     */
    public RPSTally(int nrOfRounds) { this(nrOfRounds, 0, 0, null, null); }

    /**
     * Creates an updated tally.
     *
     * If one of the players has won a majority of the rounds, then the game
     * is finished.
     *
     * If it's a draw after all rounds, then the game continues until we
     * have a winner.
     * @param result Result from round (score and player's hands).
     * @throws NullPointerException If null is passed as argument.
     * @return Updated tally.
     */
    public RPSTally update(ResultOfRound result)
    {
        int remainingRounds = this.nrOfRounds - 1;
        int scoreP1 = this.scoreP1 + result.scorePlayer1();
        int scoreP2 = this.scoreP2 + result.scorePlayer2();
        String handP1 = result.handPlayer1();
        String handP2 = result.handPlayer2();

        if ((remainingRounds == 0) && (scoreP1 == scoreP2))
            return new RPSTally(1, scoreP1, scoreP2, handP1, handP2);
        if (Math.max(scoreP1, scoreP2) > remainingRounds)
            return new RPSTally(0, scoreP1, scoreP2, handP1, handP2);
        return new RPSTally(remainingRounds, scoreP1, scoreP2, handP1, handP2);
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
     * Return remaining number of rounds.
     */
    public int remainingNrOfRounds() { return this.nrOfRounds; }

    private RPSTally(
        int nrOfRounds,
        int scoreP1, int scoreP2,
        String handP1, String handP2)
    {
        if (nrOfRounds < 0)
            throw new IllegalArgumentException();
        this.nrOfRounds = nrOfRounds;
        this.scoreP1 = scoreP1;
        this.scoreP2 = scoreP2;
        this.handP1 = handP1;
        this.handP2 = handP2;
    }

    private String checkRef(String hand)
    {
        if (hand == null)
            throw new UnsupportedOperationException();
        return hand;
    }
}
