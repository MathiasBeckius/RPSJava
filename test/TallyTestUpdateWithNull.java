import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.RPSTally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

public class TallyTestUpdateWithNull
{
    @Test
    public void Player1HandIsNull()
    {
        final RPSTally tally = new RPSTally(1);
        assertThrows(
            NullPointerException.class,
            () -> tally.update(null, HandShapes.rock()));
    }

    @Test
    public void Player2HandIsNull()
    {
        final RPSTally tally = new RPSTally(1);
        assertThrows(
            NullPointerException.class,
            () -> tally.update(HandShapes.rock(), null));
    }

    @Test
    public void BothHandsAreNull()
    {
        final RPSTally tally = new RPSTally(1);
        assertThrows(
            NullPointerException.class,
            () -> tally.update(null, null));
    }
}
