package terminalgame;

import terminalgame.ui.TerminalUI;

abstract class State
{
    public abstract State run(TerminalUI ui);
}
