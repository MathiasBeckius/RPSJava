import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.Tally;

public class TallyTestInvalidNrOfRounds
{
    @Test
    public void InvalidNrOfRounds()
    {
        int invalidNrOfRounds[] = {-1, 0, 2, 4, 6, 8, 10};
        for (int i = 0; i < invalidNrOfRounds.length; i++)
        {
            final int nrOfRounds = invalidNrOfRounds[i];
            assertThrows(
                IllegalArgumentException.class,
                () -> new Tally(nrOfRounds));
        }
    }
}
