import java.util.ArrayList;

public class L3_A5_Result {
    /**
     * Function that just is used as a container for the two byproducts of Floyd-Warshall
     */

    public ArrayList<ArrayList<L3_A5_Numbers>> Wn;
    public ArrayList<ArrayList<Integer>> Chem;

    /**
     * Constructor
     * @param w the distance matrix D
     * @param c 'matrice des intermediaires' P
     */
    public L3_A5_Result(ArrayList<ArrayList<L3_A5_Numbers>> w, ArrayList<ArrayList<Integer>> c) {
        this.Wn = w;
        this.Chem = c;
    }

}
