public class Game
{
    private GameTally tally;

    /**
     * 
     * @param nrOfRounds Number of rounds to play. Must be 1, 3, 5 or 7.
     * @throws IllegalArgumentException If nrOfRounds is invalid.
     */
    public Game(int nrOfRounds)
    {
        if (!this.validNrOfRounds(nrOfRounds))
            throw new IllegalArgumentException(
                "nrOfRounds must be 1, 3, 5 or 7!"
            );
        this.tally = new GameTally(nrOfRounds);
    }

    private Game(GameTally tally) { this.tally = tally; }

    private boolean validNrOfRounds(int nr)
    {
        return (nr >= 1) && (nr <= 7) && (nr % 2 == 1);
    }

    public Game evaluate(HandShape p1, HandShape p2)
    {
        if (this.hasEnded())
            throw new UnsupportedOperationException("Game is finished!");

        EvaluatedScore score = new EvaluatedScore(p1, p2);
        PlayersHands hands = new PlayersHands(p1, p2);
        return new Game(this.tally.update(score, hands));
    }

    public boolean hasEnded() { return this.tally.remainingNrOfRounds() == 0; }
    public GameTally tally()  { return this.tally; }

    private class EvaluatedScore implements Score
    {
        private int p1Score;
        private int p2Score;

        public EvaluatedScore(HandShape p1, HandShape p2)
        {
            this.p1Score = p1.beats(p2) ? 1 : 0;
            this.p2Score = p2.beats(p1) ? 1 : 0;
        }

        public int player1() { return this.p1Score; }
        public int player2() { return this.p2Score; }
    }

    private class PlayersHands implements HandShapes
    {
        private HandShape p1;
        private HandShape p2;

        public PlayersHands(HandShape p1, HandShape p2)
        {
            this.p1 = p1;
            this.p2 = p2;
        }

        public HandShape player1() { return this.p1; }
        public HandShape player2() { return this.p2; }
    }
}
