import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.RPSTally;

public class TallyTestInitializedState
{
    @Test
    public void InitializedStateOfNewTally()
    {
        int validNrOfRounds[] = {1, 3, 5, 7};
        int nrOfRounds;
        for (int i = 0; i < validNrOfRounds.length; i++)
        {
            nrOfRounds = validNrOfRounds[i];
            RPSTally tally = new RPSTally(nrOfRounds);
            assertEquals(0, tally.scorePlayer1());
            assertEquals(0, tally.scorePlayer2());
            assertEquals(nrOfRounds, tally.remainingNrOfRounds());
        }
    }

    @Test
    public void Player1HandOfNewTally()
    {
        assertThrows(
            UnsupportedOperationException.class,
            () -> new RPSTally(1).handPlayer1());
    }

    @Test
    public void Player2HandOfNewTally()
    {
        assertThrows(
            UnsupportedOperationException.class,
            () -> new RPSTally(1).handPlayer2());
    }
}

