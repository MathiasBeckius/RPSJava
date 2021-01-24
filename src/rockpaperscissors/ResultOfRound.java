package rockpaperscissors;

class ResultOfRound
{
    private String handP1, handP2;
    private int scoreP1, scoreP2;

    public ResultOfRound(HandShape p1, HandShape p2)
    {
        if (oneBeatsAnother(p1, p2))
           scoreP1++;
        if (oneBeatsAnother(p2, p1))
           scoreP2++;
        handP1 = p1.name();
        handP2 = p2.name();
    }

    private boolean oneBeatsAnother(HandShape p1, HandShape p2)
    {
        validateHand(p1);
        validateHand(p2);
        if (p1 instanceof Rock)
            return (p2 instanceof Scissors);
        if (p1 instanceof Paper)
            return (p2 instanceof Rock);
        if (p1 instanceof Scissors)
            return (p2 instanceof Paper);
        return false;
    }

    private void validateHand(HandShape hand)
    {
        if (hand == null)
            throw new NullPointerException();
        if (hand instanceof Rock)
            return;
        if (hand instanceof Paper)
            return;
        if (hand instanceof Scissors)
            return;
        throw new IllegalArgumentException();
    }

    public int scorePlayer1()   { return scoreP1; }
    public int scorePlayer2()   { return scoreP2; }
    public String handPlayer1() { return handP1; }
    public String handPlayer2() { return handP2; }
}
