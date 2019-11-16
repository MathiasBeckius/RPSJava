package terminalgame;

import rockpaperscissors.Tally;
import terminalgame.ui.TerminalUI;

class PresentResultState extends State
{
    private TerminalUI ui;
    private Tally tally;

    public PresentResultState(TerminalUI ui, Tally tally)
    {
        this.ui = ui;
        this.tally = tally;
    }

    public State run()
    {
        this.ui.write(this.message(this.tally));

        if (this.tally.remainingNrOfRounds() == 0)
            return new EndOfGameState(this.ui, this.tally);

        return new LetUserChooseHandShapeState(this.ui, this.tally);
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
