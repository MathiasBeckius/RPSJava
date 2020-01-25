package rockpaperscissors;

class ResultOfRound
{
    private String handP1, handP2;
    private int scoreP1, scoreP2;

    public ResultOfRound(HandShape p1, HandShape p2)
    {
        ComparableHandShape cmpHandP1 = compShape(p1);
        ComparableHandShape cmpHandP2 = compShape(p2);
        scoreP1 = cmpHandP1.beats(cmpHandP2) ? 1 : 0;
        scoreP2 = cmpHandP2.beats(cmpHandP1) ? 1 : 0;
        handP1 = cmpHandP1.name();
        handP2 = cmpHandP2.name();
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

    public int scorePlayer1()   { return scoreP1; }
    public int scorePlayer2()   { return scoreP2; }
    public String handPlayer1() { return handP1; }
    public String handPlayer2() { return handP2; }
}
