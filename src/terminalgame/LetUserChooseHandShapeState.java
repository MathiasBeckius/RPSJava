package terminalgame;

import java.util.Hashtable;
import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;
import terminalgame.ui.TerminalUI;

class LetUserChooseHandShapeState extends State
{
    private TerminalUI ui;
    private Tally tally;

    public LetUserChooseHandShapeState(TerminalUI ui, Tally tally)
    {
        this.ui = ui;
        this.tally = tally;
    }

    public State run()
    {
        HandShape playersHand = this.letUserChooseShape();
        if (playersHand == null)
            return this;
        HandShape opponentsHand = RandomShape.shape();
        this.tally = Game.updatedTally(this.tally, playersHand, opponentsHand);
        return new PresentResultState(this.ui, this.tally);
    }

    private HandShape letUserChooseShape()
    {
        String message = "[R]ock, [P]aper or [S]cissors? ";
        String userInput = this.ui.readLine(message);
        userInput = userInput.toLowerCase();
        return this.mapTable().get(userInput);
    }

    private Hashtable<String, HandShape> mapTable()
    {
        Hashtable<String, HandShape> table = new Hashtable<String, HandShape>();
        table.put("r", HandShapes.rock());
        table.put("p", HandShapes.paper());
        table.put("s", HandShapes.scissors());
        return table;
    }
}
