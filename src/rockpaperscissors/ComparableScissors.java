package rockpaperscissors;

class ComparableScissors extends Scissors implements ComparableHandShape
{
    public boolean beats(ComparableHandShape shape)
    {
        return shape instanceof ComparablePaper;
    }
}
