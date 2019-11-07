public class Scissors implements HandShape
{
    public String name()
    {
        return "scissors";
    }

    public boolean beats(HandShape shape)
    {
        return shape instanceof Paper;
    }
}
