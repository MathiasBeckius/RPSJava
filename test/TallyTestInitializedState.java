import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rockpaperscissors.Game;
import rockpaperscissors.Tally;

public class TallyTestInitializedState
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void InitializedStateOfNewTally()
    {
        int validNrOfRounds[] = {1, 3, 5, 7};
        Tally tally;
        int nrOfRounds;
        for (int i = 0; i < validNrOfRounds.length; i++)
        {
            nrOfRounds = validNrOfRounds[i];
            tally = Game.newTally(nrOfRounds);
            assertEquals(0, tally.scorePlayer1());
            assertEquals(0, tally.scorePlayer2());
            assertEquals(nrOfRounds, tally.remainingNrOfRounds());
        }
    }

    @Test
    public void Player1HandOfNewTally()
    {
        thrown.expect(UnsupportedOperationException.class);
        Game.newTally(1).handPlayer1();
    }

    @Test
    public void Player2HandOfNewTally()
    {
        thrown.expect(UnsupportedOperationException.class);
        Game.newTally(1).handPlayer2();
    }
}

