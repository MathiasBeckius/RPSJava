public class PresentResultState extends State
{
    public PresentResultState(TerminalUI ui, Game game)
    {
        super(ui, game);
    }

    public State run()
    {
        GameTally tally = this.game.tally();
        this.ui.show(this.message(tally.score(), tally.hands()));

        if (this.game.hasEnded())
            return new EndOfGameState(this.ui, this.game);

        return new LetUserChooseHandShapeState(this.ui, this.game);
    }

    private String message(Score score, HandShapes hands)
    {
        return String.format(
            "You chose %s, your opponent chose %s.\n",
            hands.player1().name(),
            hands.player2().name()
        ) + String.format(
            "You have %d points, your opponent has %d\n\n",
            score.player1(),
            score.player2()
        );
    }
}
