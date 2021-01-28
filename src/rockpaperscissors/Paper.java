package rockpaperscissors;

class Paper extends PaperShapedHand
{
    public String name() { return "paper"; }

    public boolean beats(HandShape hand)
    {
        validate(hand);
        return hand instanceof RockShapedHand;
    }
}
