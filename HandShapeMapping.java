import java.util.Hashtable;

public class HandShapeMapping
{
    private Hashtable<String, HandShape> mapTable;

    public HandShapeMapping(String rock, String paper, String scissors)
    {
        this.mapTable = new Hashtable<String, HandShape>();
        this.mapTable.put(rock, new Rock());
        this.mapTable.put(paper, new Paper());
        this.mapTable.put(scissors, new Scissors());
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
