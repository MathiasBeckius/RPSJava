import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

public class TallyTestUpdateWithNull
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void Player1HandIsNull()
    {
        Tally tally = Game.newTally(1);
        HandShape hand = HandShapes.rock();
        thrown.expect(NullPointerException.class);
        Game.updatedTally(tally, null, hand);
    }

    @Test
    public void Player2HandIsNull()
    {
        Tally tally = Game.newTally(1);
        HandShape hand = HandShapes.rock();
        thrown.expect(NullPointerException.class);
        Game.updatedTally(tally, hand, null);
    }

    @Test
    public void BothHandsAreNull()
    {
        Tally tally = Game.newTally(1);
        thrown.expect(NullPointerException.class);
        Game.updatedTally(tally, null, null);
    }

    @Test
    public void TallyIsNull()
    {
        Tally tally = Game.newTally(1);
        HandShape hand = HandShapes.rock();
        thrown.expect(NullPointerException.class);
        Game.updatedTally(null, hand, hand);
    }

    @Test
    public void TallyAndPlayer1AreNull()
    {
        Tally tally = Game.newTally(1);
        HandShape hand = HandShapes.rock();
        thrown.expect(NullPointerException.class);
        Game.updatedTally(null, null, hand);
    }

    @Test
    public void TallyAndPlayer2AreNull()
    {
        Tally tally = Game.newTally(1);
        HandShape hand = HandShapes.rock();
        thrown.expect(NullPointerException.class);
        Game.updatedTally(null, hand, null);
    }

    @Test
    public void AllArgumentsAreNull()
    {
        thrown.expect(NullPointerException.class);
        Game.updatedTally(null, null, null);
    }
}
