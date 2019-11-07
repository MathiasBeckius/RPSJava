public class StartOfGameState extends State
{
    public StartOfGameState(TerminalUI ui)
    {
        super(ui, new Game(3));
    }

    public State run()
    {
        this.ui.clear();
        this.ui.show(this.message());
        return new LetUserChooseHandShapeState(this.ui, this.game);
    }

    private String message()
    {
        return "Starting game...\n\n";
    }
}
