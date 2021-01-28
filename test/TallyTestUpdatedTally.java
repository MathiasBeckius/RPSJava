import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.Tally;

public class TallyTestUpdatedTally
{
    private void assertScore(Tally tally, int p1Score, int p2Score)
    {
        assertEquals(p1Score, tally.scorePlayer1());
        assertEquals(p2Score, tally.scorePlayer2());
    }

    @Test
    public void TestGame()
    {
        Tally tally = new Tally(7);

        tally = tally.player1Wins();
        assertScore(tally, 1, 0);
        assertEquals(6, tally.remainingNrOfRounds());

        tally = tally.player2Wins();
        assertScore(tally, 1, 1);
        assertEquals(5, tally.remainingNrOfRounds());

        tally = tally.player1Wins();
        assertScore(tally, 2, 1);
        assertEquals(4, tally.remainingNrOfRounds());

        tally = tally.player2Wins();
        assertScore(tally, 2, 2);
        assertEquals(3, tally.remainingNrOfRounds());

        tally = tally.nobodyWins();
        assertScore(tally, 2, 2);
        assertEquals(2, tally.remainingNrOfRounds());

        tally = tally.nobodyWins();
        assertScore(tally, 2, 2);
        assertEquals(1, tally.remainingNrOfRounds());

        tally = tally.player1Wins();
        assertScore(tally, 3, 2);
        assertEquals(0, tally.remainingNrOfRounds());
    }

    @Test
    public void UpdateTallyWhenGameIsFinishedIsNotAllowed()
    {
        Tally tally = new Tally(1);
        final Tally tallyNoMoreRounds = tally.player1Wins();
        assertThrows(
            UnsupportedOperationException.class,
            () -> tallyNoMoreRounds.nobodyWins());
    }

    @Test
    public void GameIsExtendedWhenItsADraw_1Round()
    {
        Tally tally = new Tally(1);
        tally = tally.nobodyWins();
        assertEquals(1, tally.remainingNrOfRounds());
        tally = tally.player1Wins();
        assertEquals(0, tally.remainingNrOfRounds());
    }

    @Test
    public void GameIsFinishedWhenOnePlayerHasWonMostRounds_7Rounds()
    {
        Tally tally = new Tally(7);
        tally = tally.player1Wins();
        assertEquals(6, tally.remainingNrOfRounds());
        tally = tally.player1Wins();
        assertEquals(5, tally.remainingNrOfRounds());
        tally = tally.player1Wins();
        assertEquals(4, tally.remainingNrOfRounds());
        tally = tally.player1Wins();
        assertEquals(0, tally.remainingNrOfRounds());
    }
}
