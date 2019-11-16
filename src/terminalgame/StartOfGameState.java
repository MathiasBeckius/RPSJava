package terminalgame;

import rockpaperscissors.Game;
import rockpaperscissors.Tally;
import terminalgame.ui.TerminalUI;

class StartOfGameState extends State
{
    private TerminalUI ui;
    private Tally tally;

    public StartOfGameState(TerminalUI ui)
    {
        this.ui = ui;
        this.tally = Game.newTally(3);
    }

    public State run()
    {
        this.ui.clearScreen();
        this.ui.write(this.message());
        return new LetUserChooseHandShapeState(this.ui, this.tally);
    }

    private String message()
    {
        return "Starting game...\n\n";
    }
}
