package rockpaperscissors;

/**
 * Access the handshapes within the game of Rock-Paper-Scissors.
 */
public final class HandShapes
{
    /**
     * Returns an instance of the rock.
     */
    public static HandShape rock()
    {
        return new Rock();
    }

    /**
     * Returns an instance of the paper.
     */
    public static HandShape paper()
    {
        return new Paper();
    }

    /**
     * Returns an instance of the scissors.
     */
    public static HandShape scissors()
    {
        return new Scissors();
    }

    /**
     * Returns true for a valid handshape, and false for an invalid one.
     */
    private static boolean isValid(HandShape hand)
    {
        if (hand == null)
            throw new NullPointerException();

        if (hand instanceof Rock)
            return true;
        if (hand instanceof Paper)
            return true;
        if (hand instanceof Scissors)
            return true;

        return false;
    }

    public static boolean oneBeatsAnother(HandShape p1, HandShape p2)
    {
        if (!HandShapes.isValid(p1) || !HandShapes.isValid(p2))
            throw new IllegalArgumentException();
        if (p1 instanceof Rock)
            return (p2 instanceof Scissors);
        if (p1 instanceof Paper)
            return (p2 instanceof Rock);
        if (p1 instanceof Scissors)
            return (p2 instanceof Paper);
        return false;
    }
}
