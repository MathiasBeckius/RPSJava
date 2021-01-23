package terminalgame;

import rockpaperscissors.Tally;
import terminalgame.ui.TerminalUI;

class StartOfGameState extends State
{
    public State run(TerminalUI ui)
    {
        ui.clearScreen();
        ui.write("Starting game...\n\n");
        return new LetUserChooseHandShapeState(new Tally(3));
    }
}
