package rockpaperscissors;

class RPSTally implements Tally
{
    private int nrOfRounds, scoreP1, scoreP2;
    private String handP1, handP2;

    public RPSTally(int nrOfRounds)  { this(nrOfRounds, 0, 0, null, null); }
    public String handPlayer1()      { return this.checkRef(this.handP1); }
    public String handPlayer2()      { return this.checkRef(this.handP2); }
    public int scorePlayer1()        { return this.scoreP1; }
    public int scorePlayer2()        { return this.scoreP2; }
    public int remainingNrOfRounds() { return this.nrOfRounds; }

    public RPSTally update(ResultOfRound result)
    {
        if (this.nrOfRounds == 0)
            throw new UnsupportedOperationException();

        int remainingRounds = this.nrOfRounds - 1;
        int scoreP1 = this.scoreP1 + result.scorePlayer1();
        int scoreP2 = this.scoreP2 + result.scorePlayer2();
        String handP1 = result.handPlayer1();
        String handP2 = result.handPlayer2();

        if (this.itsADraw(remainingRounds, scoreP1, scoreP2))
            return new RPSTally(1, scoreP1, scoreP2, handP1, handP2);
        if (this.onePlayerHasWonMostRounds(remainingRounds, scoreP1, scoreP2))
            return new RPSTally(0, scoreP1, scoreP2, handP1, handP2);
        return new RPSTally(remainingRounds, scoreP1, scoreP2, handP1, handP2);
    }

    private boolean itsADraw(int remainingRounds, int scoreP1, int scoreP2)
    {
        return (remainingRounds == 0) && (scoreP1 == scoreP2);
    }

    private boolean onePlayerHasWonMostRounds(
        int remainingRounds, int scoreP1, int scoreP2)
    {
        return (Math.max(scoreP1, scoreP2) > remainingRounds) && (scoreP1 != scoreP2);
    }

    private RPSTally(
        int nrOfRounds,
        int scoreP1, int scoreP2,
        String handP1, String handP2)
    {
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
