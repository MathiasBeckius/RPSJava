package rockpaperscissors;

/**
 * Interface of a generic handshape for the Rock-Paper-Scissors game.
 */
public abstract class HandShape
{
    public abstract String name();
    public abstract boolean beats(HandShape hand);

    final protected void validate(HandShape hand)
    {
    }
}
