import java.util.Arrays;

public class Deer extends Animal{

    String name = "Deer";


    public Deer(int x, int y, int[] maxPosition, int count) {
        super(x, y, maxPosition, count);
        this.count = count;
    }
    public int getCount() { return  count; }
    public String getName() { return name; }


    @Override
    public String toString() {
        return this.name + " " + count + " Moved to " + Arrays.toString(this.position);
    }
}
