package terminalgame;

import terminalgame.ui.TerminalUI;

/**
 * Terminal-based version of the classic Rock-Paper-Scissors game.
 */
public class TerminalGame
{
    private State state;

    /**
     * Creates an instance of the game.
     * @param ui Instance of the terminal-based user interface.
     * @throws NullPointerException If null is passed as an argument.
     */
    public TerminalGame(TerminalUI ui)
    {
        if (ui == null)
            throw new NullPointerException();
        this.state = new StartOfGameState(ui);
    }

    /**
     * Checks if the game is still running, i.e. the game is not terminated.
     */
    public boolean isRunning()
    {
        this.state = this.state.run();
        return !(this.state instanceof TerminateGameState);
    }
}
