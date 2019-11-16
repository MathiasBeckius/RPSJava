package terminalgame;

import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import terminalgame.ui.TerminalUI;

class LetUserChooseHandShapeState extends State
{
    private TerminalUI ui;
    private Tally tally;
    private HandShapeMapping mapping;

    public LetUserChooseHandShapeState(TerminalUI ui, Tally tally)
    {
        this.ui = ui;
        this.tally = tally;
        this.mapping = new HandShapeMapping("r", "p", "s");
    }

    public State run()
    {
        HandShape playersHand;
        String userInput = this.ui.readLine(this.message());
        userInput = userInput.toLowerCase();
        try
        {
            playersHand = this.mapping.mapToShape(userInput);
        }
        catch (IllegalArgumentException e)
        {
            return this;
        }
        HandShape opponentsHand = RandomShape.shape();
        this.tally = Game.updatedTally(this.tally, playersHand, opponentsHand);
        return new PresentResultState(this.ui, this.tally);
    }

    private String message()
    {
        return "[R]ock, [P]aper or [S]cissors? ";
    }
}
