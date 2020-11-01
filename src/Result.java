import java.util.ArrayList;

public class Result {
    /**
     * Function that just is used as a container for the two byproducts of Floyd-Warshall
     */

    public ArrayList<ArrayList<Numbers>> Wn;
    public ArrayList<ArrayList<Integer>> Chem;

    /**
     * Constructor
     * @param w the distance matrix D
     * @param c 'matrice des intermediaires' P
     */
    public Result(ArrayList<ArrayList<Numbers>> w, ArrayList<ArrayList<Integer>> c) {
        this.Wn = w;
        this.Chem = c;
    }

}
