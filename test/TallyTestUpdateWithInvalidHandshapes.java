import static org.junit.Assert.assertThrows;
import org.junit.Test;

import rockpaperscissors.RPSTally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

public class TallyTestUpdateWithInvalidHandshapes
{
    @Test
    public void InvalidHandshapes()
    {
        final RPSTally tally = new RPSTally(1);
        InvalidHandshape invalidHand = new InvalidHandshape();
        HandShape hand = HandShapes.rock();
        // Expect exception for one invalid hand
        assertThrows(
            IllegalArgumentException.class,
            () -> tally.update(invalidHand, hand));
        // Expect exception in case the other hand is invalid
        assertThrows(
            IllegalArgumentException.class,
            () -> tally.update(invalidHand, hand));
        // Expect exception for invalid hands
        assertThrows(
            IllegalArgumentException.class,
            () -> tally.update(invalidHand, invalidHand));
    }

    private class InvalidHandshape implements HandShape
    {
        public String name() { return "invalid handshape"; }
    }
}
