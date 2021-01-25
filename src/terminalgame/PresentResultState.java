package terminalgame;

import rockpaperscissors.Tally;
import terminalgame.ui.TerminalUI;

class PresentResultState extends State
{
    private Tally tally;

    public PresentResultState(Tally tally)
    {
        this.tally = tally;
    }

    public State run(TerminalUI ui)
    {
        ui.write(message());

        if (tally.remainingNrOfRounds() == 0)
            return new EndOfGameState(tally);

        return new LetUserChooseHandShapeState(tally);
    }

    private String message()
    {
        return String.format(
            "You have %d points, your opponent has %d\n\n",
            tally.scorePlayer1(), tally.scorePlayer2());
    }
}
