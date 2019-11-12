package rockpaperscissors;

class ComparablePaper extends Paper implements ComparableHandShape
{
    public boolean beats(ComparableHandShape shape)
    {
        return shape instanceof ComparableRock;
    }
}
