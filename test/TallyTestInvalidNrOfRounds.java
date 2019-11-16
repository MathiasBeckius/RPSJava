import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rockpaperscissors.Game;

public class TallyTestInvalidNrOfRounds
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void InvalidNrOfRounds_0()
    {
        thrown.expect(IllegalArgumentException.class);
        Game.newTally(0);
    }

    @Test
    public void InvalidNrOfRounds_2()
    {
        thrown.expect(IllegalArgumentException.class);
        Game.newTally(2);
    }

    @Test
    public void InvalidNrOfRounds_4()
    {
        thrown.expect(IllegalArgumentException.class);
        Game.newTally(4);
    }

    @Test
    public void InvalidNrOfRounds_6()
    {
        thrown.expect(IllegalArgumentException.class);
        Game.newTally(6);
    }

    @Test
    public void InvalidNrOfRounds_8()
    {
        thrown.expect(IllegalArgumentException.class);
        Game.newTally(8);
    }
}
