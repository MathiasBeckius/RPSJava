package rockpaperscissors;

class Rock implements HandShape
{
    public String name() { return "rock"; }
    public boolean beats(HandShape shape) { return shape instanceof Scissors; }
}
