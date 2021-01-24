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
}
