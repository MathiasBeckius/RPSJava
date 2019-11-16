import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

public class TallyTestUpdateWithInvalidHandshapes
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void Player1HandIsInvalid()
    {
        Tally tally = Game.newTally(1);
        InvalidHandshape invalidHand = new InvalidHandshape();
        HandShape hand = HandShapes.rock();
        thrown.expect(IllegalArgumentException.class);
        Game.updatedTally(tally, invalidHand, hand);
    }

    @Test
    public void Player2HandIsInvalid()
    {
        Tally tally = Game.newTally(1);
        InvalidHandshape invalidHand = new InvalidHandshape();
        HandShape hand = HandShapes.rock();
        thrown.expect(IllegalArgumentException.class);
        Game.updatedTally(tally, hand, invalidHand);
    }

    @Test
    public void BothHandsAreInvalid()
    {
        Tally tally = Game.newTally(1);
        InvalidHandshape invalidHand = new InvalidHandshape();
        thrown.expect(IllegalArgumentException.class);
        Game.updatedTally(tally, invalidHand, invalidHand);
    }

    private class InvalidHandshape implements HandShape
    {
        public String name() { return "invalid handshape"; }
    }
}
