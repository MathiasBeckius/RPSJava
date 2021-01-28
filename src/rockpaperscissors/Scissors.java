package rockpaperscissors;

class Scissors extends ScissorsShapedHand
{
    public String name() { return "scissors"; }

    public boolean beats(HandShape hand)
    {
        validate(hand);
        return hand instanceof PaperShapedHand;
    }
}
