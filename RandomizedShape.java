import java.util.Random;

public class RandomizedShape
{
    private HandShape shape;

    public RandomizedShape()
    {
        this.shape = this.randomShape();
    }

    public HandShape shape()
    {
        return this.shape;
    }

    private HandShape randomShape()
    {
        Random rnd = new Random();
        int x = rnd.nextInt(3000);
        if (x < 1000)
            return new Rock();
        if (x < 2000)
            return new Paper();
        return new Scissors();
    }
}
