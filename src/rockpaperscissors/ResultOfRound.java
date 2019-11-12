package rockpaperscissors;

/**
 * Determine the result from a round of Rock-Paper-Scissors.
 */
class ResultOfRound
{
    private String handP1, handP2;
    private int scoreP1, scoreP2;

    /**
     * Determine the result of two handshapes.
     * @param p1 Hand of Player 1.
     * @param p2 Hand of Player 2.
     * @throws IllegalArgumentException If invalid handshapes (or null) are
     * passed as arguments.
     */
    public ResultOfRound(ComparableHandShape handP1, ComparableHandShape handP2)
    {
        if (!this.validShape(handP1) || !this.validShape(handP2))
            throw new IllegalArgumentException();
        this.scoreP1 = handP1.beats(handP2) ? 1 : 0;
        this.scoreP2 = handP2.beats(handP1) ? 1 : 0;
        this.handP1 = handP1.name();
        this.handP2 = handP2.name();
    }

    /**
     * Handshape of Player 1.
     */
    public String handPlayer1() { return this.handP1; }

    /**
     * Handshape of Player 2.
     */
    public String handPlayer2() { return this.handP2; }

    /**
     * Score, i.e. result of this round, for Player 1.
     * Will be 0 or 1 points.
     */
    public int scorePlayer1() { return this.scoreP1; }

    /**
     * Score, i.e. result of this round, for Player 2.
     * Will be 0 or 1 points.
     */
    public int scorePlayer2() { return this.scoreP2; }

    private boolean validShape(ComparableHandShape hs)
    {
        return
            (hs instanceof Rock) ||
            (hs instanceof Paper) ||
            (hs instanceof Scissors);
    }
}
