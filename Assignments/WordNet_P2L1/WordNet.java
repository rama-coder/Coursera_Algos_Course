import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by RAGA on 4/26/2014.
 */
public class WordNet
{
    private HashMap<Integer,String> nouns;
    private HashMap<Integer, String> synsetIdMap;
    private HashMap<Integer, TreeSet<Integer>> hyperIdMap;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms)
    {
        In synsetsIn = new In(synsets);
        In hypernymsIn = new In(hypernyms);

        nouns = new HashMap<Integer,String>();
        synsetIdMap = new HashMap<Integer, String>();
        hyperIdMap = new HashMap<Integer, TreeSet<Integer>>();

        String synIdLine;
        String [] synIdLineWords;

        while ( ! synsetsIn.isEmpty())
        {
            synIdLine = synsetsIn.readLine();
            synIdLineWords = synIdLine.split(",");
            int synId = Integer.parseInt(synIdLineWords[0]);
            nouns.put(synId, synIdLineWords[1]);
            synsetIdMap.put(synId, synIdLineWords[2]);
        }

        String hyperIdLine;
        String [] hyperIdLineWords;

        while ( ! hypernymsIn.isEmpty())
        {
            hyperIdLine = hypernymsIn.readLine();
            hyperIdLineWords = hyperIdLine.split(",");
            TreeSet<Integer> hyperIds = new TreeSet<Integer>();

            for(int i=1; i < hyperIdLineWords.length; i++)
                hyperIds.add(Integer.parseInt(hyperIdLineWords[i]));

            hyperIdMap.put(Integer.parseInt(hyperIdLineWords[0]), hyperIds);
        }
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
    }
}
