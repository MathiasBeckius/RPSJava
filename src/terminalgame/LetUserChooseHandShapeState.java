package terminalgame;

import java.util.Hashtable;
import java.util.Random;
import rockpaperscissors.Tally;
import rockpaperscissors.HandShapes;
import rockpaperscissors.HandShape;
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
        HandShape p1 = letUserChooseShape(ui);
        // If no match for user input...
        if (p1 == null)
            return this; // Remain in state, i.e. let user try again

        HandShape p2 = opponentsHand();

        ui.write(message(p1, p2));

        return new PresentResultState(tally.update(p1, p2));
    }

    private String message(HandShape p1, HandShape p2)
    {
        return String.format(
            "You chose %s, your opponent chose %s.\n",
            p1.name(), p2.name());
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
