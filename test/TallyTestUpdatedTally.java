import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

public class TallyTestUpdatedTally
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
        Tally tally = Game.newTally(7);
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        HandShape paper = HandShapes.paper();

        tally = Game.updatedTally(tally, rock, scissors);
        assertPlayers(tally, 1, rock.name(), 0, scissors.name());
        assertEquals(6, tally.remainingNrOfRounds());

        tally = Game.updatedTally(tally, rock, paper);
        assertPlayers(tally, 1, rock.name(), 1, paper.name());
        assertEquals(5, tally.remainingNrOfRounds());

        tally = Game.updatedTally(tally, scissors, paper);
        assertPlayers(tally, 2, scissors.name(), 1, paper.name());
        assertEquals(4, tally.remainingNrOfRounds());

        tally = Game.updatedTally(tally, scissors, rock);
        assertPlayers(tally, 2, scissors.name(), 2, rock.name());
        assertEquals(3, tally.remainingNrOfRounds());

        tally = Game.updatedTally(tally, paper, paper);
        assertPlayers(tally, 2, paper.name(), 2, paper.name());
        assertEquals(2, tally.remainingNrOfRounds());

        tally = Game.updatedTally(tally, rock, rock);
        assertPlayers(tally, 2, rock.name(), 2, rock.name());
        assertEquals(1, tally.remainingNrOfRounds());

        tally = Game.updatedTally(tally, scissors, paper);
        assertPlayers(tally, 3, scissors.name(), 2, paper.name());
        assertEquals(0, tally.remainingNrOfRounds());
    }

    @Test
    public void UpdateTallyWhenGameIsFinishedIsNotAllowed()
    {
        Tally tally = Game.newTally(1);
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        tally = Game.updatedTally(tally, rock, scissors);
        thrown.expect(UnsupportedOperationException.class);
        Game.updatedTally(tally, rock, scissors);
    }

    @Test
    public void GameIsExtendedWhenItsADraw_1Round()
    {
        Tally tally = Game.newTally(1);
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        tally = Game.updatedTally(tally, rock, rock);
        assertEquals(1, tally.remainingNrOfRounds());
        tally = Game.updatedTally(tally, rock, scissors);
        assertEquals(0, tally.remainingNrOfRounds());
    }

    @Test
    public void GameIsFinishedWhenOnePlayerHasWonMostRounds_7Rounds()
    {
        Tally tally = Game.newTally(7);
        HandShape rock = HandShapes.rock();
        HandShape scissors = HandShapes.scissors();
        tally = Game.updatedTally(tally, rock, scissors);
        assertEquals(6, tally.remainingNrOfRounds());
        tally = Game.updatedTally(tally, rock, scissors);
        assertEquals(5, tally.remainingNrOfRounds());
        tally = Game.updatedTally(tally, rock, scissors);
        assertEquals(4, tally.remainingNrOfRounds());
        tally = Game.updatedTally(tally, rock, scissors);
        assertEquals(0, tally.remainingNrOfRounds());
    }
}
