import java.util.Arrays;

public class Animal {
    String name = "Animal";
    Boolean isDead = false;
    int[] position;
    int[] maxPosition;
    int count;



    public Animal(int x, int y, int[] maxPosition, int count){
        setPosition(x,y);
        setMaxPosition(maxPosition);
        this.count = count;
    }

    public int getCount() { return  count; }
    public String getName() { return name; }
    public int[] getMaxPosition() { return maxPosition; }
    public int[] getPosition() { return position; }

    public void kill() {
        this.isDead = true;
    }

    public void setName(String name) { this.name = name; }
    public void setMaxPosition(int[] max) { this.maxPosition = max; }
    public void setPosition(int x, int y) { this.position = new int[]{x,y}; }
    public void setPosition(int x[]) { this.position = x; }

}