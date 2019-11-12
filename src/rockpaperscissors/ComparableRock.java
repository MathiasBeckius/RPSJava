package rockpaperscissors;

class ComparableRock extends Rock implements ComparableHandShape
{
    public boolean beats(ComparableHandShape shape)
    {
        return shape instanceof ComparableScissors;
    }
}
