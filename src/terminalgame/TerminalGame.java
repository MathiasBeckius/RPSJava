package terminalgame;

import terminalgame.ui.TerminalUI;

/**
 * Terminal-based version of the classic Rock-Paper-Scissors game.
 */
public class TerminalGame
{
    private State state;
    private TerminalUI ui;

    /**
     * Creates an instance of the game.
     * @param terminalUI Instance of the terminal-based user interface.
     * @throws NullPointerException If null is passed as an argument.
     */
    public TerminalGame(TerminalUI terminalUI)
    {
        if (terminalUI == null)
            throw new NullPointerException();

        ui = terminalUI;
        state = new StartOfGameState();
    }

    /**
     * Checks if the game is still running, i.e. the game is not terminated.
     */
    public boolean isRunning()
    {
        state = state.run(ui);
        return !(state instanceof TerminateGameState);
    }
}
