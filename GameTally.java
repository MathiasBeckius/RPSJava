public class GameTally
{
    private int nrOfRounds;
    private Score score = new InitializedScore();
    private HandShapes hands = null;

    /**
     * 
     * @param nrOfRounds Number of rounds to play. Must be at least 0!
     * @throws IllegalArgumentException If nrOfRounds is invalid.
     */
    public GameTally(int nrOfRounds)
    {
        this.setNrOfRounds(nrOfRounds);
    }

    private GameTally(int nrOfRounds, Score score, HandShapes hands)
    {
        this.setNrOfRounds(nrOfRounds);
        this.score = score;
        this.hands = hands;
    }

    private void setNrOfRounds(int nrOfRounds)
    {
        if (nrOfRounds < 0)
            throw new IllegalArgumentException(
                "nrOfRounds can't be less than 0!"
            );
        this.nrOfRounds = nrOfRounds;
    }

    public GameTally update(Score score, HandShapes hands)
    {
        return new GameTally(
            this.nrOfRounds - 1,
            new UpdatedScore(this.score, score),
            hands
        );
    }

    public HandShapes hands()
    {
        if (this.hands == null)
            throw new UnsupportedOperationException(
                "First round has not been played yet!"
            );
        return this.hands;
    }

    public Score score()             { return this.score; }
    public int remainingNrOfRounds() { return this.nrOfRounds; }

    private class InitializedScore implements Score
    {
        public int player1() { return 0; }
        public int player2() { return 0; }
    }

    private class UpdatedScore implements Score
    {
        private int p1;
        private int p2;

        public UpdatedScore(Score score1, Score score2)
        {
            this.p1 = score1.player1() + score2.player1();
            this.p2 = score1.player2() + score2.player2();
        }

        public int player1() { return this.p1; }
        public int player2() { return this.p2; }
    }
}
