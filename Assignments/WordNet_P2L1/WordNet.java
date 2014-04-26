import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by RAGA on 4/26/2014.
 */
public class WordNet
{
    private TreeSet<String> nouns;
    private HashMap<String, String> synsetIdMap;
    private HashMap<String, TreeSet<Integer>> hyperIdMap;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms)
    {
        In synsetsIn = new In(synsets);
        In hypernymsIn = new In(hypernyms);

        nouns = new TreeSet<String>();
        synsetIdMap = new HashMap<String, String>();
        hyperIdMap = new HashMap<String, TreeSet<Integer>>();

        String synIdLine;
        String [] synIdLineWords;

        while ( ! synsetsIn.isEmpty())
        {
            synIdLine = synsetsIn.readLine();
            synIdLineWords = synIdLine.split(",");

            synsetIdMap.put(synIdLineWords[0], synIdLineWords[1]);
        }

        String hyperIdLine;
        String [] hyperIdLineWords;

        while ( ! synsetsIn.isEmpty())
        {
            hyperIdLine = hypernymsIn.readLine();
            synIdLineWords = hyperIdLine.split(",");
            TreeSet<Integer> hyperIds = new TreeSet<Integer>();

            for(int i=1; i < synIdLineWords.length; i++)
                hyperIds.add(Integer.parseInt(synIdLineWords[i]));

            hyperIdMap.put(synIdLineWords[0], hyperIds);
        }
    }

    // the set of nouns (no duplicates), returned as an Iterable
    public Iterable<String> nouns()
    {
        return nouns;
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word)
    {
        return nouns.contains(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB)
    {
        return -1;
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB)
    {
        return null;
    }

    // for unit testing of this class
    public static void main(String[] args)
    {

    }
}
