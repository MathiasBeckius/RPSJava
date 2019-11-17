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
        ui.write(this.message(this.tally));

        if (this.tally.remainingNrOfRounds() == 0)
            return new EndOfGameState(this.tally);

        return new LetUserChooseHandShapeState(this.tally);
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
