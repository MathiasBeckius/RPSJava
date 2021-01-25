import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

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
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        HandShape paper = HandShapes.paper();

        tally = tally.update(rock, scissors);
        assertScore(tally, 1, 0);
        assertEquals(6, tally.remainingNrOfRounds());

        tally = tally.update(rock, paper);
        assertScore(tally, 1, 1);
        assertEquals(5, tally.remainingNrOfRounds());

        tally = tally.update(scissors, paper);
        assertScore(tally, 2, 1);
        assertEquals(4, tally.remainingNrOfRounds());

        tally = tally.update(scissors, rock);
        assertScore(tally, 2, 2);
        assertEquals(3, tally.remainingNrOfRounds());

        tally = tally.update(paper, paper);
        assertScore(tally, 2, 2);
        assertEquals(2, tally.remainingNrOfRounds());

        tally = tally.update(rock, rock);
        assertScore(tally, 2, 2);
        assertEquals(1, tally.remainingNrOfRounds());

        tally = tally.update(scissors, paper);
        assertScore(tally, 3, 2);
        assertEquals(0, tally.remainingNrOfRounds());
    }

    @Test
    public void UpdateTallyWhenGameIsFinishedIsNotAllowed()
    {
        Tally tally = new Tally(1);
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        final Tally tallyNoMoreRounds = tally.update(rock, scissors);
        assertThrows(
            UnsupportedOperationException.class,
            () -> tallyNoMoreRounds.update(rock, scissors));
    }

    @Test
    public void GameIsExtendedWhenItsADraw_1Round()
    {
        Tally tally = new Tally(1);
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        tally = tally.update(rock, rock);
        assertEquals(1, tally.remainingNrOfRounds());
        tally = tally.update(rock, scissors);
        assertEquals(0, tally.remainingNrOfRounds());
    }

    @Test
    public void GameIsFinishedWhenOnePlayerHasWonMostRounds_7Rounds()
    {
        Tally tally = new Tally(7);
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        tally = tally.update(rock, scissors);
        assertEquals(6, tally.remainingNrOfRounds());
        tally = tally.update(rock, scissors);
        assertEquals(5, tally.remainingNrOfRounds());
        tally = tally.update(rock, scissors);
        assertEquals(4, tally.remainingNrOfRounds());
        tally = tally.update(rock, scissors);
        assertEquals(0, tally.remainingNrOfRounds());
    }
}
