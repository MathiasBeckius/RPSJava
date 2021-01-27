import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.Tally;

public class TallyTestInitializedState
{
    @Test
    public void InitializedStateOfNewTally()
    {
        int validNrOfRounds[] = {1, 3, 5, 7};
        for (int i = 0; i < validNrOfRounds.length; i++)
        {
            int nrOfRounds = validNrOfRounds[i];
            Tally tally = new Tally(nrOfRounds);
            assertEquals(0, tally.scorePlayer1());
            assertEquals(0, tally.scorePlayer2());
            assertEquals(nrOfRounds, tally.remainingNrOfRounds());
        }
    }
}

