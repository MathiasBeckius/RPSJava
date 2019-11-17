package terminalgame;

import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import terminalgame.ui.TerminalUI;

class StartOfGameState extends State
{
    public State run(TerminalUI ui)
    {
        ui.clearScreen();
        ui.write("Starting game...\n\n");
        return new LetUserChooseHandShapeState(Game.newTally(3));
    }
}
