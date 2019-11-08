import java.util.Hashtable;
import rockpaperscissors.HandShapes;
import rockpaperscissors.HandShape;

public class HandShapeMapping
{
    private Hashtable<String, HandShape> mapTable;

    public HandShapeMapping(String rock, String paper, String scissors)
    {
        this.mapTable = new Hashtable<String, HandShape>();
        this.mapTable.put(rock, HandShapes.rock());
        this.mapTable.put(paper, HandShapes.paper());
        this.mapTable.put(scissors, HandShapes.scissors());
    }

    public HandShape mapToShape(String key)
    {
        HandShape shape = this.mapTable.get(key);
        if (shape == null)
            throw new IllegalArgumentException(
                "Can't match '" + key + "' with HandShape!"
            );
        return shape;
    }
}
