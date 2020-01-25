package rockpaperscissors;

class RPSTally implements Tally
{
    private int nrOfRounds, scoreP1, scoreP2;
    private String handP1, handP2;

    public RPSTally(int rounds)      { this(rounds, 0, 0, null, null); }
    public String handPlayer1()      { return checkRef(handP1); }
    public String handPlayer2()      { return checkRef(handP2); }
    public int scorePlayer1()        { return scoreP1; }
    public int scorePlayer2()        { return scoreP2; }
    public int remainingNrOfRounds() { return nrOfRounds; }

    public RPSTally update(ResultOfRound result)
    {
        if (remainingNrOfRounds() == 0)
            throw new UnsupportedOperationException();

        int newScoreP1 = scorePlayer1() + result.scorePlayer1();
        int newScoreP2 = scorePlayer2() + result.scorePlayer2();

        return new RPSTally(
            calcRemainingNrOfRounds(newScoreP1, newScoreP2),
            newScoreP1,
            newScoreP2,
            result.handPlayer1(),
            result.handPlayer2());
    }

    private int calcRemainingNrOfRounds(int scoreP1, int scoreP2)
    {
        int rounds = remainingNrOfRounds() - 1;

        // If it's a draw when all rounds are played...
        if ((rounds == 0) && (scoreP1 == scoreP2))
            return 1; // Play another round

        // If one player has won most rounds...
        if ((Math.max(scoreP1, scoreP2) > rounds) && (scoreP1 != scoreP2))
            return 0; // Then we have a winner - stop playing

        // Keep playing
        return rounds;
    }

    private RPSTally(
        int rounds,
        int p1Score, int p2Score,
        String p1Hand, String p2Hand)
    {
        nrOfRounds = rounds;
        scoreP1 = p1Score;
        scoreP2 = p2Score;
        handP1 = p1Hand;
        handP2 = p2Hand;
    }

    private String checkRef(String hand)
    {
        if (hand == null)
            throw new UnsupportedOperationException();
        return hand;
    }
}
