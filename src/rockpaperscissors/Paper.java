package rockpaperscissors;

class Paper implements HandShape
{
    public String name() { return "paper"; }
    public boolean beats(HandShape shape) { return shape instanceof Rock; }
}
