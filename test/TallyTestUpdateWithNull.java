import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

public class TallyTestUpdateWithNull
{
    @Test
    public void Player1HandIsNull()
    {
        final Tally tally = new Tally(1);
        assertThrows(
            NullPointerException.class,
            () -> tally.update(null, HandShapes.rock()));
    }

    @Test
    public void Player2HandIsNull()
    {
        final Tally tally = new Tally(1);
        assertThrows(
            NullPointerException.class,
            () -> tally.update(HandShapes.rock(), null));
    }

    @Test
    public void BothHandsAreNull()
    {
        final Tally tally = new Tally(1);
        assertThrows(
            NullPointerException.class,
            () -> tally.update(null, null));
    }
}
