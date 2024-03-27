import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Comparison {
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();

        Trie trie = new Trie();
        HashMap<String, String> hashMap = new HashMap<>();

        // Using library implementation of Red-Black Tree because it is better than what I can write
        TreeMap<String, String> redBlackTree = new TreeMap<>();

        String url = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt";

        // Insert words from url
        try {
            URL words = new URL(url);

            BufferedReader reader = new BufferedReader(new InputStreamReader(words.openStream()));

            String word;
            while ((word = reader.readLine()) != null) {
                wordList.add(word);

                trie.insert(word);
                redBlackTree.put(word,word);
                hashMap.put(word,word);
            }
            reader.close();
        } catch (IOException e) { e.printStackTrace(); }

        LocalDateTime clock = LocalDateTime.now();
        for (String s : wordList){
            trie.search(s);
        }
        System.out.println("Trie : " + Duration.between(clock, LocalDateTime.now()));

        clock = LocalDateTime.now();
        for (String s : wordList){
            redBlackTree.get(s);
        }
        System.out.println("Red Black Tree : " + Duration.between(clock, LocalDateTime.now()));

        clock = LocalDateTime.now();
        for (String s : wordList){
            hashMap.get(s);
        }
        System.out.println("Hashtable : " + Duration.between(clock, LocalDateTime.now()));


    }
}
