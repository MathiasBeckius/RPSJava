package terminalgame;

import rockpaperscissors.Tally;
import terminalgame.ui.TerminalUI;

class EndOfGameState extends State
{
    private Tally tally;

    public EndOfGameState(Tally tally)
    {
        this.tally = tally;
    }

    public State run(TerminalUI ui)
    {
        ui.write(this.message(this.tally));
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
