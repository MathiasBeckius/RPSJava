package terminalgame;

import rockpaperscissors.RPSTally;
import terminalgame.ui.TerminalUI;

class StartOfGameState extends State
{
    public State run(TerminalUI ui)
    {
        ui.clearScreen();
        ui.write("Starting game...\n\n");
        return new LetUserChooseHandShapeState(new RPSTally(3));
    }
}
