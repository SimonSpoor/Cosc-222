
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // There is no reason to name the nodes, I was just having some fun

        Node Annie = new Node(0);
        Node Joe = new Node(1);
        Node Katie = new Node(2);
        Node Kyla = new Node(3);
        Node Matt = new Node(4);
        Node Karl = new Node(5);
        Node Jeff = new Node(6);


        // Set 1
        Annie.addFriend(Katie);
        Katie.addFriend(Annie);
        Joe.addFriend(Kyla);
        Kyla.addFriend(Annie);

        // Set 2
        Matt.addFriend(Karl);
        Karl.addFriend(Matt);
        Jeff.addFriend(Matt);
        Jeff.addFriend(Karl);

        // Create Set Manager
        SetManager sm =  new SetManager(Arrays.asList(Annie, Joe, Katie, Kyla, Matt, Karl, Jeff));

        System.out.println(Annie.isConnected(Joe) ? "Annie is connected to Joe" : "Annie is not connected to Joe");
    }

}

/*
    NOTES

    Data structure is a modified Disjoint Set List
    I have deleted the Graph.java and Edge.java files because I did not need them

    I couldn't find a way to union all compatible lists without nested loops
    Time to generate disjoint sets is not ideal [expected: O(n^4), worst case: O(n^5)]
    However, we are assuming that it's pre-processed which means that doesn't matter, so I did not fix it

    The relationships are stored in Hashmaps providing for fast query time [expected: O(1), worst case: O(n)]
    Therefore, the least amount of time needed to check that Annie and Joe are connected is O(1)

    Test files are in the directory Lab6/Tests
    Diagram of node relationships is located at Lab6/diagram.png
 */