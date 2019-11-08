import rockpaperscissors.Game;
import rockpaperscissors.HandShape;

public class LetUserChooseHandShapeState extends State
{
    private HandShapeMapping mapping;

    public LetUserChooseHandShapeState(TerminalUI ui, Game game)
    {
        super(ui, game);
        this.mapping = new HandShapeMapping("r", "p", "s");
    }

    public State run()
    {
        HandShape playersHand;
        String userInput = this.ui.read(this.message());
        userInput = userInput.toLowerCase();
        try
        {
            playersHand = this.mapping.mapToShape(userInput);
        }
        catch (IllegalArgumentException e)
        {
            return this;
        }
        HandShape opponentsHand = RandomShape.shape();
        this.game = this.game.evaluate(playersHand, opponentsHand);
        return new PresentResultState(this.ui, this.game);
    }

    private String message()
    {
        return "[R]ock, [P]aper or [S]cissors? ";
    }
}
