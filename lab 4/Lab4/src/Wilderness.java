import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Wilderness {
    HashMap<String, Animal> map = new HashMap<>();
    ArrayList<String> remove = new ArrayList<>();

    public Wilderness(ArrayList<Animal> animals){
        // Populate Hashmap
        for (Animal a: animals){
            map.put(Arrays.toString(a.position), a);
        }
    }

    public void doTimestep(){
        // Move all animals then remove dead ones
        // Clear list of dead animals before next loop
        for (Animal a: map.values()) move(a, (int) (Math.random()*4));
        for (String r: remove) map.remove(r);
        remove.clear();
    }


    public void move(Animal a, int x){
        // Choose Direction of Movement
        // Re-call method if an animal tries to move outside the grid
        // Check for other animals in the space an animal wants to move to
        switch ((int) (x)){
            case 0 -> {
                // Move North:  (x,y) -> (x,y+1)    if (y) < max(y)
                if (a.getPosition()[1] < a.getMaxPosition()[1]){
                    int[] newPosition = new int[]{a.getPosition()[0], ++a.getPosition()[1]};
                    if (!checkWilderness(a, newPosition))  a.setPosition(newPosition);
                }
                else move(a, (int) (Math.random()*4));
            }
            case 1 -> {
                // Move East: (x,y) -> (x+1,y)      if (x) < max(x)
                if (a.getPosition()[0] < a.getMaxPosition()[0]){
                    int[] newPosition = new int[]{++a.getPosition()[0], a.getPosition()[1]};
                    if (!checkWilderness(a, newPosition))  a.setPosition(newPosition);
                }
                else move(a, (int) (Math.random()*4));
            }
            case 2 -> {
                // Move South: (x,y) -> (x,y-1)     if (y) > 0
                if (a.getPosition()[1] > 0){
                    int[] newPosition = new int[]{a.getPosition()[0], --a.getPosition()[1]};
                    if (!checkWilderness(a, newPosition))  a.setPosition(newPosition);
                }
                else move(a, (int) (Math.random()*4));
            }
            case 3 -> {
                // Move West: (x,y) -> (x-1,y)      if (x) > 0
                if (a.getPosition()[0] > 0){
                    int[] newPosition = new int[]{--a.getPosition()[0], a.getPosition()[1]};
                    if (!checkWilderness(a, newPosition))  a.setPosition(newPosition);
                }
                else move(a, (int) (Math.random()*4));
            }
        }
    }



    public boolean checkWilderness(Animal currentAnimal, int[] newPosition) {
        // Check for animals on a grid space while an animal attempts to move
        // Mark all dead animals and add to an arraylist for removal
        boolean isOccupied = false;
        String newPositionStr = Arrays.toString(newPosition);

        if (map.containsKey(newPositionStr)) {
            Animal otherAnimal = map.get(newPositionStr);
            if (!currentAnimal.isDead && !otherAnimal.isDead){
                if (otherAnimal.getName().equalsIgnoreCase("wolf") && currentAnimal.getName().equalsIgnoreCase("deer")) {
                    System.out.println("Deer " + currentAnimal.getCount() + " Was killed by Wolf " + otherAnimal.getCount() + " On " + newPositionStr);

                    currentAnimal.kill();
                    remove.add(Arrays.toString(currentAnimal.getPosition()));

                } else if (otherAnimal.getName().equalsIgnoreCase("deer") && currentAnimal.getName().equalsIgnoreCase("wolf")) {
                    System.out.println("Deer " + otherAnimal.getCount() + " Was killed by Wolf " + currentAnimal.getCount() + " On " + newPositionStr);
                    remove.add(newPositionStr);
                    otherAnimal.kill();
                }
                else {
                    isOccupied = true;
                }
            }
        }
        return isOccupied;
    }

    @Override
    public String toString() {
        String s = "";
        for (Animal a: map.values()) s = s.concat(a.toString() + "\n");
        return s;
    }
}
