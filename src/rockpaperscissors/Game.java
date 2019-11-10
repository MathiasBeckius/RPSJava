package rockpaperscissors;

public class Game
{
    private Tally tally;

    /**
     * 
     * @param nrOfRounds Number of rounds to play. Must be 1, 3, 5 or 7.
     * @throws IllegalArgumentException If nrOfRounds is invalid.
     */
    public Game(int nrOfRounds)
    {
        if (!this.validNrOfRounds(nrOfRounds))
            throw new IllegalArgumentException();
        this.tally = new Tally(nrOfRounds);
    }

    private Game(Tally tally) { this.tally = tally; }

    private boolean validNrOfRounds(int nr)
    {
        return (nr >= 1) && (nr <= 7) && (nr % 2 == 1);
    }

    public Game evaluate(HandShape p1, HandShape p2)
    {
        if (this.hasEnded())
            throw new UnsupportedOperationException();
        return new Game(this.tally.update(new ResultOfRound(p1, p2)));
    }

    public boolean hasEnded() { return this.tally.remainingNrOfRounds() == 0; }
    public Tally tally() { return this.tally; }
}
