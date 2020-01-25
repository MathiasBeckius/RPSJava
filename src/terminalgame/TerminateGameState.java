package terminalgame;

import terminalgame.ui.TerminalUI;

class TerminateGameState extends State
{
    // When the game is terminated, then we'll remain in this state!
    public State run(TerminalUI ui) { return this; }
}
