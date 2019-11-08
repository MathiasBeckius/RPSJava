import rockpaperscissors.Game;
import rockpaperscissors.Tally;

public class PresentResultState extends State
{
    public PresentResultState(TerminalUI ui, Game game)
    {
        super(ui, game);
    }

    public State run()
    {
        this.ui.show(this.message(this.game.tally()));

        if (this.game.hasEnded())
            return new EndOfGameState(this.ui, this.game);

        return new LetUserChooseHandShapeState(this.ui, this.game);
    }

    private String message(Tally tally)
    {
        return String.format(
            "You chose %s, your opponent chose %s.\n",
            tally.handPlayer1(),
            tally.handPlayer2()
        ) + String.format(
            "You have %d points, your opponent has %d\n\n",
            tally.scorePlayer1(),
            tally.scorePlayer2()
        );
    }
}
