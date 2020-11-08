import java.util.ArrayList;

public class A5Result {
    /**
     * Function that just is used as a container for the two byproducts of Floyd-Warshall
     */

    public ArrayList<ArrayList<A5Numbers>> Wn;
    public ArrayList<ArrayList<Integer>> Chem;

    /**
     * Constructor
     * @param w the distance matrix D
     * @param c 'matrice des intermediaires' P
     */
    public A5Result(ArrayList<ArrayList<A5Numbers>> w, ArrayList<ArrayList<Integer>> c) {
        this.Wn = w;
        this.Chem = c;
    }

}
