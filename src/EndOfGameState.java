import rockpaperscissors.Game;
import rockpaperscissors.Tally;

public class EndOfGameState extends State
{
    public EndOfGameState(TerminalUI ui, Game game)
    {
        super(ui, game);
    }

    public State run()
    {
        this.ui.show(this.message(this.game.tally()));
        return new TerminateGameState();
    }

    private String message(Tally tally)
    {
        return String.format(
            "%s\n\nEnd of game!\n",
            this.result(tally.scorePlayer1(), tally.scorePlayer2())
        );
    }

    private String result(int p1, int p2)
    {
        if (p1 > p2)
            return "You win!";
        if (p1 < p2)
            return "You loose!";
        return "It's a draw!";
    }
}
