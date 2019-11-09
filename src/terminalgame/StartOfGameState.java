package terminalgame;

import rockpaperscissors.Game;
import terminalgame.ui.TerminalUI;

class StartOfGameState extends State
{
    public StartOfGameState(TerminalUI ui)
    {
        super(ui, new Game(3));
    }

    public State run()
    {
        this.ui.clearScreen();
        this.ui.write(this.message());
        return new LetUserChooseHandShapeState(this.ui, this.game);
    }

    private String message()
    {
        return "Starting game...\n\n";
    }
}
