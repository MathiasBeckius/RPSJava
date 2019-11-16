import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;

public class TallyTestUpdateWithInvalidTally
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void TallyIsInvalid()
    {
        Tally invalidTally = new InvalidTally();
        HandShape hand = HandShapes.rock();
        thrown.expect(IllegalArgumentException.class);
        Game.updatedTally(invalidTally, hand, hand);
    }

    private class InvalidTally implements Tally
    {
        public int remainingNrOfRounds() { return 0; }
        public int scorePlayer1()        { return 0; }
        public int scorePlayer2()        { return 0; }
        public String handPlayer1()      { return ""; }
        public String handPlayer2()      { return ""; }
    }
}
