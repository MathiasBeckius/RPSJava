package terminalgame;

import java.util.Random;
import rockpaperscissors.HandShapes;
import rockpaperscissors.HandShape;

class RandomShape
{
    public static HandShape shape()
    {
        Random rnd = new Random();
        int x = rnd.nextInt(3000);
        if (x < 1000)
            return HandShapes.rock();
        if (x < 2000)
            return HandShapes.paper();
        return HandShapes.scissors();
    }
}
