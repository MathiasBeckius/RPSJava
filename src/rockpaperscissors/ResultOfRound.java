package rockpaperscissors;

class ResultOfRound
{
    private String handP1, handP2;
    private int scoreP1, scoreP2;

    public ResultOfRound(HandShape p1, HandShape p2)
    {
        ComparableHandShape handP1 = this.compShape(p1);
        ComparableHandShape handP2 = this.compShape(p2);

        this.scoreP1 = handP1.beats(handP2) ? 1 : 0;
        this.scoreP2 = handP2.beats(handP1) ? 1 : 0;
        this.handP1 = handP1.name();
        this.handP2 = handP2.name();
    }

    private ComparableHandShape compShape(HandShape shape)
    {
        if (shape == null)
            throw new NullPointerException();

        try
        {
            return (ComparableHandShape)shape;
        }
        catch (ClassCastException e)
        {
            throw new IllegalArgumentException();
        }
    }

    public int scorePlayer1()   { return this.scoreP1; }
    public int scorePlayer2()   { return this.scoreP2; }
    public String handPlayer1() { return this.handP1; }
    public String handPlayer2() { return this.handP2; }
}
