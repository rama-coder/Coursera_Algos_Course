import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by RAGA on 4/26/2014.
 */
public class WordNet
{
    private HashMap<Integer,String> nouns;
    private HashMap<Integer, String> glossMap;
    private HashMap<Integer, TreeSet<Integer>> hyperIdMap;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms)
    {
        In synsetsIn = new In(synsets);
        In hypernymsIn = new In(hypernyms);

        nouns = new HashMap<Integer,String>();
        glossMap = new HashMap<Integer, String>();
        hyperIdMap = new HashMap<Integer, TreeSet<Integer>>();

        String synIdLine;
        String [] synIdLineWords;

        while ( ! synsetsIn.isEmpty())
        {
            TreeSet<String> synSet = new TreeSet<String>();

            synIdLine = synsetsIn.readLine();
            synIdLineWords = synIdLine.split(",");
            int synId = Integer.parseInt(synIdLineWords[0]);

            nouns.put(synId, synIdLineWords[1].trim());
            glossMap.put(synId, synIdLineWords[2].trim());
        }

        String hyperIdLine;
        String [] hyperIdLineWords;

        while ( ! hypernymsIn.isEmpty())
        {
            hyperIdLine = hypernymsIn.readLine();
            hyperIdLineWords = hyperIdLine.split(",");
            TreeSet<Integer> hyperIds = new TreeSet<Integer>();

            for(int i=1; i < hyperIdLineWords.length; i++)
                hyperIds.add(Integer.parseInt(hyperIdLineWords[i].trim()));

            hyperIdMap.put(Integer.parseInt(hyperIdLineWords[0]), hyperIds);
        }

        // Construct the Digraph
        Digraph G = new Digraph(hyperIdMap.size()+1);

        for (int v:hyperIdMap.keySet())
        {
            TreeSet<Integer> hyperNymSet = hyperIdMap.get(v);

            for(int w:hyperNymSet)
                G.addEdge(v,w);
        }

        StdOut.printf("Given Digraph is %s", G);

        // Find if G is a rooted DAG


    }

    // the set of nouns (no duplicates), returned as an Iterable
    public Iterable<String> nouns()
    {
        return nouns.values();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word)
    {
        if (word == null)
            return false;

        StdOut.printf("Known nouns are " + nouns.values());

        return nouns.values().contains(word);
    }

    private boolean areNouns(String nounA, String nounB)
    {
        return isNoun(nounA) && isNoun(nounB);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB)
    {
        if ( ! areNouns(nounA, nounB))
            throw new IllegalArgumentException("Atleast one of the nouns are invalid nouns");

        return -1;
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB)
    {
        if ( ! areNouns(nounA, nounB))
            throw new IllegalArgumentException("Atleast one of the nouns are invalid nouns");

        return null;
    }

    // for unit testing of this class
    public static void main(String[] args)
    {
            WordNet wn = new WordNet(args[0], args[1]);

            StdOut.println("Printing nouns and hypernyms...");

            for(String noun:wn.nouns())
                StdOut.println(noun);

            StdOut.printf("Is Noun %s",wn.isNoun(args[2]));
    }
}
