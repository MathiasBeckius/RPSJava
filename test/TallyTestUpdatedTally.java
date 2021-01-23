import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

public class TallyTestUpdatedTally
{
    private void assertPlayers(
        Tally tally,
        int p1Score, String p1Shape,
        int p2Score, String p2Shape)
    {
        assertEquals(p1Score, tally.scorePlayer1());
        assertEquals(p2Score, tally.scorePlayer2());
        assertEquals(p1Shape, tally.handPlayer1());
        assertEquals(p2Shape, tally.handPlayer2());
    }

    @Test
    public void TestGame()
    {
        Tally tally = new Tally(7);
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        HandShape paper = HandShapes.paper();

        tally = tally.update(rock, scissors);
        assertPlayers(tally, 1, rock.name(), 0, scissors.name());
        assertEquals(6, tally.remainingNrOfRounds());

        tally = tally.update(rock, paper);
        assertPlayers(tally, 1, rock.name(), 1, paper.name());
        assertEquals(5, tally.remainingNrOfRounds());

        tally = tally.update(scissors, paper);
        assertPlayers(tally, 2, scissors.name(), 1, paper.name());
        assertEquals(4, tally.remainingNrOfRounds());

        tally = tally.update(scissors, rock);
        assertPlayers(tally, 2, scissors.name(), 2, rock.name());
        assertEquals(3, tally.remainingNrOfRounds());

        tally = tally.update(paper, paper);
        assertPlayers(tally, 2, paper.name(), 2, paper.name());
        assertEquals(2, tally.remainingNrOfRounds());

        tally = tally.update(rock, rock);
        assertPlayers(tally, 2, rock.name(), 2, rock.name());
        assertEquals(1, tally.remainingNrOfRounds());

        tally = tally.update(scissors, paper);
        assertPlayers(tally, 3, scissors.name(), 2, paper.name());
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
