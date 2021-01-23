import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.RPSTally;

public class TallyTestInvalidNrOfRounds
{
    @Test
    public void InvalidNrOfRounds_0()
    {
        assertThrows(
            IllegalArgumentException.class,
            () -> new RPSTally(0));
    }

    @Test
    public void InvalidNrOfRounds_2()
    {
        assertThrows(
            IllegalArgumentException.class,
            () -> new RPSTally(2));
    }

    @Test
    public void InvalidNrOfRounds_4()
    {
        assertThrows(
            IllegalArgumentException.class,
            () -> new RPSTally(4));
    }

    @Test
    public void InvalidNrOfRounds_6()
    {
        assertThrows(
            IllegalArgumentException.class,
            () -> new RPSTally(6));
    }

    @Test
    public void InvalidNrOfRounds_8()
    {
        assertThrows(
            IllegalArgumentException.class,
            () -> new RPSTally(8));
    }
}
