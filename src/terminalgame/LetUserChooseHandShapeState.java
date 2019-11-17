package terminalgame;

import java.util.Hashtable;
import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import rockpaperscissors.HandShape;
import rockpaperscissors.HandShapes;
import terminalgame.ui.TerminalUI;

class LetUserChooseHandShapeState extends State
{
    private Tally tally;

    public LetUserChooseHandShapeState(Tally tally)
    {
        this.tally = tally;
    }

    public State run(TerminalUI ui)
    {
        HandShape playersHand = this.letUserChooseShape(ui);
        if (playersHand == null)
            return this;
        HandShape opponentsHand = RandomShape.shape();
        return new PresentResultState(
            Game.updatedTally(this.tally, playersHand, opponentsHand));
    }

    private HandShape letUserChooseShape(TerminalUI ui)
    {
        String message = "[R]ock, [P]aper or [S]cissors? ";
        String userInput = ui.readLine(message);
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
