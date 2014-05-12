/**
 * Created by RAGA on 4/30/2014.
 */
public class SymbolGraph
{
    private ST<String, Integer> st;
    private String[] keys;
    private Graph g;

    public SymbolGraph(String fileName, String sepChar)
    {

    }

    public boolean contains(String name)
    {
        return st.contains(name);
    }

    public int index(String name)
    {
        return st.get(name);
    }

    public String name(int v)
    {
        return keys[v];
    }
}
