import java.util.Arrays;

public class Wolf extends Animal{

    String name = "Wolf";


    public Wolf(int x, int y, int[] maxPosition, int count) {
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
