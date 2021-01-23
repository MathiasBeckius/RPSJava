package terminalgame;

import java.util.Hashtable;
import java.util.Random;
import rockpaperscissors.RPSTally;
import rockpaperscissors.HandShapes;
import rockpaperscissors.HandShape;
import terminalgame.ui.TerminalUI;

class LetUserChooseHandShapeState extends State
{
    private RPSTally tally;

    public LetUserChooseHandShapeState(RPSTally tally)
    {
        this.tally = tally;
    }

    public State run(TerminalUI ui)
    {
        HandShape playersHand = letUserChooseShape(ui);
        // If no match for user input...
        if (playersHand == null)
            return this; // Remain in state, i.e. let user try again

        return new PresentResultState(tally.update(playersHand, opponentsHand()));
    }

    private HandShape letUserChooseShape(TerminalUI ui)
    {
        String message = "[R]ock, [P]aper or [S]cissors? ";
        String userInput = ui.readLine(message);
        userInput = userInput.toLowerCase();
        // Will return null if there's no match for userInput
        return mapTable().get(userInput);
    }

    private Hashtable<String, HandShape> mapTable()
    {
        Hashtable<String, HandShape> table = new Hashtable<String, HandShape>();
        table.put("r", HandShapes.rock());
        table.put("p", HandShapes.paper());
        table.put("s", HandShapes.scissors());
        return table;
    }

    private HandShape opponentsHand()
    {
        Random rnd = new Random();
        int x = rnd.nextInt(3000);
        if (x < 1000)
            return HandShapes.rock();
        if (x < 2000)
            return HandShapes.paper();
        return HandShapes.scissors();
    }
}
