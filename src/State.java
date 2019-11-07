public abstract class State
{
    protected TerminalUI ui;
    protected Game game;

    public State()
    {
        this(null, null);
    }

    public State(TerminalUI ui, Game game)
    {
        this.ui = ui;
        this.game = game;
    }

    public abstract State run();
}
