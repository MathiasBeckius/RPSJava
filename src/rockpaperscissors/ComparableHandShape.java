package rockpaperscissors;

/**
 * Interface for comparing of handshapes within the Rock-Paper-Scissors API.
 */
interface ComparableHandShape extends HandShape
{
    public boolean beats(ComparableHandShape shape);
}
