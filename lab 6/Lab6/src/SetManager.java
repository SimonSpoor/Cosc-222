import java.util.ArrayList;
import java.util.List;

// Manages a list of Sets
public class SetManager {
    ArrayList<Set> sets = new ArrayList<>();


    public SetManager(List<Node> nodes){
        for (Node n: nodes){
            sets.add(new Set(n));
        }
        collapseSets();
    }

    public ArrayList<Set> getSets() { return sets; }


    // Union all union compatible sets
    // The time complexity on this is abysmal, but I can't think of a better solution
    public void collapseSets() {
        // expected case: O(n^4)
        // worst case: O(n^5)

        // Catch edge case where list is empty
        if (sets.size() == 0) return;

        ArrayList<Set> tempList = new ArrayList<>(sets);
        ArrayList<Set> noUnionsFound = new ArrayList<>();

        // Iterate through until no further unions are possible
        while (tempList.size() > 1){                                // O(n)

            for (int i = 0; i < tempList.size(); i++){              // O(n^2)
                boolean unionFound = false;

                Set temp = tempList.get(i);
                tempList.remove(i);

                // Union temp if it has a union compatible partner
                for (Set s: tempList){                              // O(n^3)
                    if (temp.isUnionCompatible(s)){                 // expected: O(n^4) worst case: O(n^5)
                        s.union(temp);

                        // Prevent unnecessary unions
                        unionFound = true;
                        break;
                    }
                }

                // If temp has no union compatible partners add to separate list
                if (!unionFound) noUnionsFound.add(temp);

            }
        }

        // Update the list of node connections
        for (Set s: sets) s.updateNodeConnections();

        // Update list of sets
        noUnionsFound.add(tempList.get(0));
        this.sets = noUnionsFound;
    }
}
