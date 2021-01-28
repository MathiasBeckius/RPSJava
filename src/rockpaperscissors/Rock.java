package rockpaperscissors;

class Rock extends RockShapedHand
{
    public String name() { return "rock"; }

    public boolean beats(HandShape hand)
    {
        validate(hand);
        return hand instanceof ScissorsShapedHand;
    }
}
