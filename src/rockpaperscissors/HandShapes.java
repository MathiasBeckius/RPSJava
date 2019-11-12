package rockpaperscissors;

/**
 * Access the handshapes within the game of Rock-Paper-Scissors.
 */
public class HandShapes
{
    /**
     * Returns an instance of the rock.
     */
    public static HandShape rock()
    {
        return (HandShape) new ComparableRock();
    }

    /**
     * Returns an instance of the paper.
     */
    public static HandShape paper()
    {
        return (HandShape) new ComparablePaper();
    }

    /**
     * Returns an instance of the scissors.
     */
    public static HandShape scissors()
    {
        return (HandShape) new ComparableScissors();
    }
}
