package rockpaperscissors;

class ResultOfRound
{
    private String handP1, handP2;
    private int scoreP1, scoreP2;

    public ResultOfRound(HandShape handP1, HandShape handP2)
    {
        if (!this.validShape(handP1) && !this.validShape(handP2))
            throw new IllegalArgumentException();
        this.scoreP1 = handP1.beats(handP2) ? 1 : 0;
        this.scoreP2 = handP2.beats(handP1) ? 1 : 0;
        this.handP1 = handP1.name();
        this.handP2 = handP2.name();
    }

    public String handPlayer1() { return this.handP1; }
    public String handPlayer2() { return this.handP2; }
    public int scorePlayer1() { return this.scoreP1; }
    public int scorePlayer2() { return this.scoreP2; }

    private boolean validShape(HandShape hs)
    {
        return
            (hs instanceof Rock) ||
            (hs instanceof Paper) ||
            (hs instanceof Scissors);
    }
}
